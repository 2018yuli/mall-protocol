package com.ydual.xgen.util.readxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Parser {
	private static final String BACKLASH = "/";
	private static final String DOT = ".";
	private static final String DOLLAR = "$";
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private static List listElePath = null;

	private static class MementoImpl implements ParseMemento {

		public Map getMapRe() {
			return mapRe;
		}

		private Map mapRe;

		public MementoImpl(Map mapRe) {
			this.mapRe = new HashMap();
			this.mapRe = mapRe;
		}
	}

	private Parser() {
	}

	public static ReadXmlExpression parse(String expr) {
		ReadXmlExpression retObj = null;
		ParseMemento memento = ParseCaretaker.getInstance().retriveMemento();
		Map mapRe = null;
		if (memento == null)
			mapRe = new HashMap();
		else
			mapRe = ((MementoImpl) memento).getMapRe();
		String notParseExpr = searchMaxLongEquals(expr, mapRe);
		String needParseExpr = "";
		if (notParseExpr.trim().length() == 0)
			needParseExpr = expr;
		else if (notParseExpr.length() < expr.length())
			needParseExpr = expr.substring(notParseExpr.length() + 1);
		else
			needParseExpr = "";
		if (needParseExpr.trim().length() > 0)
			retObj = parse2(needParseExpr, notParseExpr, mapRe);
		else
			retObj = (ReadXmlExpression) mapRe.get(notParseExpr);
		ParseCaretaker.getInstance().saveMemento(new MementoImpl(mapRe));
		return retObj;
	}

	private static String searchMaxLongEquals(String expr, Map mapRe) {
		for (boolean flag = mapRe.containsKey(expr); !flag;) {
			int lastIndex = expr.lastIndexOf("/");
			if (lastIndex > 0) {
				expr = expr.substring(0, lastIndex);
				flag = mapRe.containsKey((new StringBuilder(String.valueOf(expr))).append("/").toString());
			} else {
				expr = "";
				flag = true;
			}
		}

		return expr;
	}

	private static ReadXmlExpression parse2(String needParseExpr, String notParseExpr, Map mapRe) {
		listElePath = new ArrayList();
		Map mapPath = parseMapPath(needParseExpr);
		Map mapPathAndRe = mapPath2Expression(mapPath);
		ReadXmlExpression prefixRE = (ReadXmlExpression) mapRe
				.get((new StringBuilder(String.valueOf(notParseExpr))).append("/").toString());
		if (prefixRE != null)
			prefixRE = (ReadXmlExpression) ((ReadXmlExpression) mapRe
					.get((new StringBuilder(String.valueOf(notParseExpr))).append("/").toString())).clone();
		ReadXmlExpression retTree = buildTree(notParseExpr, prefixRE, mapPathAndRe, mapRe);
		return retTree;
	}

	private static Map parseMapPath(String expr) {
		Map mapPath = new HashMap();
		StringBuffer pathBuffer = new StringBuffer();
		StringTokenizer tokenizer = new StringTokenizer(expr, "/");
		while (tokenizer.hasMoreTokens()) {
			String onePath = tokenizer.nextToken();
			if (tokenizer.hasMoreTokens()) {
				pathBuffer.append((new StringBuilder(String.valueOf(onePath))).append("/").toString());
				setParsePath(pathBuffer, onePath, false, false, mapPath);
				continue;
			}
			int dotIndex = onePath.indexOf(".");
			if (dotIndex > 0) {
				String eleName = onePath.substring(0, dotIndex);
				String propName = onePath.substring(dotIndex + 1);
				pathBuffer.append((new StringBuilder(String.valueOf(eleName))).append(".").toString());
				setParsePath(pathBuffer, eleName, false, false, mapPath);
				pathBuffer.append(propName);
				setParsePath(pathBuffer, propName, true, true, mapPath);
			} else {
				pathBuffer.append(onePath);
				setParsePath(pathBuffer, onePath, true, false, mapPath);
			}
			break;
		}
		return mapPath;
	}

	private static void setParsePath(StringBuffer buffer, String eleName, boolean end, boolean propertyValue,
			Map mapPath) {
		ParseModel pm = new ParseModel();
		pm.setEnd(end);
		pm.setPropertyValue(propertyValue);
		pm.setSingleValue(eleName.indexOf("$") <= 0);
		eleName = eleName.replace("$", "");
		int tempBegin = 0;
		int tempEnd = 0;
		if ((tempBegin = eleName.indexOf("[")) > 0) {
			tempEnd = eleName.indexOf("]");
			pm.setCondition(eleName.substring(tempBegin + 1, tempEnd));
			eleName = eleName.substring(0, tempBegin);
		}
		pm.setEleName(eleName);
		mapPath.put(buffer.toString(), pm);
		listElePath.add(buffer.toString());
	}

	private static Map mapPath2Expression(Map mapPath) {
		Map map = new HashMap();
		String key;
		ReadXmlExpression obj;
		for (Iterator iterator = listElePath.iterator(); iterator.hasNext(); map.put(key, obj)) {
			key = (String) iterator.next();
			ParseModel pm = (ParseModel) mapPath.get(key);
			obj = parseModel2ReadXmlExpression(pm);
		}

		return map;
	}

	private static ReadXmlExpression parseModel2ReadXmlExpression(ParseModel pm) {
		ReadXmlExpression obj = null;
		if (!pm.isEnd()) {
			if (pm.isSingleValue())
				obj = new ElementExpression(pm.getEleName(), pm.getCondition());
			else
				obj = new ElementsExpression(pm.getEleName(), pm.getCondition());
		} else if (pm.isPropertyValue()) {
			if (pm.isSingleValue())
				obj = new PropertyTerminalExpression(pm.getEleName());
			else
				obj = new PropertysTerminalExpression(pm.getEleName());
		} else if (pm.isSingleValue())
			obj = new ElementTerminalExpression(pm.getEleName(), pm.getCondition());
		else
			obj = new ElementsTerminalExpression(pm.getEleName(), pm.getCondition());
		return obj;
	}

	private static ReadXmlExpression buildTree(String prefixStr, ReadXmlExpression prefixRe, Map mapPathAndRe,
			Map mapRe) {
		ReadXmlExpression retRe = prefixRe;
		ReadXmlExpression preRe = getLastRE(prefixRe);
		for (Iterator iterator = listElePath.iterator(); iterator.hasNext();) {
			String path = (String) iterator.next();
			ReadXmlExpression re = (ReadXmlExpression) mapPathAndRe.get(path);
			if (preRe == null) {
				preRe = re;
				retRe = re;
			} else if (preRe instanceof ElementExpression) {
				ElementExpression ele = (ElementExpression) preRe;
				ele.addEle(re);
				preRe = re;
			} else if (preRe instanceof ElementsExpression) {
				ElementsExpression eles = (ElementsExpression) preRe;
				eles.addEle(re);
				preRe = re;
			}
			if (prefixStr != null && prefixStr.trim().length() > 0)
				mapRe.put((new StringBuilder(String.valueOf(prefixStr))).append("/").append(path).toString(),
						(ReadXmlExpression) retRe.clone());
			else
				mapRe.put(path, (ReadXmlExpression) retRe.clone());
		}

		return retRe;
	}

	private static ReadXmlExpression getLastRE(ReadXmlExpression prefixRe) {
		ReadXmlExpression lastRe = prefixRe;
		boolean flag = true;
		while (flag)
			if (lastRe instanceof ElementExpression) {
				if (((ElementExpression) lastRe).getEles().size() > 0) {
					lastRe = (ReadXmlExpression) ((ElementExpression) lastRe).getEles().get(0);
					if (lastRe instanceof ElementExpression)
						flag = ((ElementExpression) lastRe).getEles().size() > 0;
					else if (lastRe instanceof ElementsExpression)
						flag = ((ElementsExpression) lastRe).getEles().size() > 0;
					else
						flag = false;
				} else {
					flag = false;
				}
			} else if (lastRe instanceof ElementsExpression) {
				if (((ElementsExpression) lastRe).getEles().size() > 0) {
					lastRe = (ReadXmlExpression) ((ElementsExpression) lastRe).getEles().get(0);
					if (lastRe instanceof ElementExpression)
						flag = ((ElementExpression) lastRe).getEles().size() > 0;
					else if (lastRe instanceof ElementsExpression)
						flag = ((ElementsExpression) lastRe).getEles().size() > 0;
					else
						flag = false;
				} else {
					flag = false;
				}
			} else {
				flag = false;
			}
		return lastRe;
	}

}
