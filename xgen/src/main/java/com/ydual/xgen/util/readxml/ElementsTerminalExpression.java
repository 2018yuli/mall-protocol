package com.ydual.xgen.util.readxml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Element;
/**
 * 组合模式树叶对象
 * @author l8989
 *
 */
public class ElementsTerminalExpression extends ReadXmlExpression {
	private String eleName;
	private String condition;

	public ElementsTerminalExpression(String eleName, String condition) {
		this.eleName = "";
		this.condition = "";
		this.eleName = eleName;
		this.condition = condition;
	}

	public String[] interpret(Context ctx) {
		List pEles = ctx.getPreEles();
		List nowEles = new ArrayList();
		Element pEle;
		for (Iterator iterator = pEles.iterator(); iterator.hasNext(); nowEles.addAll(ctx.getNowEles(pEle, eleName)))
			pEle = (Element) iterator.next();

		for (Iterator it = nowEles.iterator(); it.hasNext();) {
			Element ele = (Element) it.next();
			if (!ctx.judgeCondition(ele, condition))
				it.remove();
		}

		String ss[] = new String[nowEles.size()];
		for (int i = 0; i < ss.length; i++) {
			Element ele = (Element) nowEles.get(i);
			if (ele.getFirstChild() != null)
				ss[i] = ele.getFirstChild().getNodeValue();
			else
				ss[i] = "";
		}

		return ss;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (Exception err) {
			err.printStackTrace();
		}
		return obj;
	}

}
