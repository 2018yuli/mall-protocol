package com.ydual.xgen.util.readxml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Element;
/**
 * 解释器模式，组合模式树枝对象
 * 如：root/a/b/c.name
 * root/a/b/d$ 多个d元素的值的集合
 * root/a/b/d$.id$ 多个d元素的id属性的值的集合
 * root/a/e$[id=e1]/f
 * 太复杂的语法不合适使用解释器模式；
 * 对效率要求很高的情况下，不适合使用解释器模式；
 * @author l8989
 *
 */
public class ElementExpression extends ReadXmlExpression {
	private List eles;
	private String eleName;
	private String condition;

	public void setEles(List eles) {
		this.eles = eles;
	}

	public ElementExpression(String eleName, String condition) {
		eles = new ArrayList();
		this.eleName = "";
		this.condition = "";
		this.eleName = eleName;
		this.condition = condition;
	}

	public List getEles() {
		return eles;
	}

	public void addEle(ReadXmlExpression ele) {
		eles.add(ele);
	}

	public boolean removeEle(ReadXmlExpression ele) {
		eles.remove(ele);
		return true;
	}

	public void removeAllEles() {
		eles.clear();
	}

	public String[] interpret(Context ctx) {
		List pEles = ctx.getPreEles();
		Element ele = null;
		List nowEles = new ArrayList();
		if (pEles.size() == 0) {
			ele = ctx.getDocument().getDocumentElement();
			pEles.add(ele);
			ctx.setPreEles(pEles);
		} else {
			for (Iterator iterator = pEles.iterator(); iterator.hasNext();) {
				Element pEle = (Element) iterator.next();
				nowEles.addAll(ctx.getNowEles(pEle, eleName));
				if (nowEles.size() > 0)
					break;
			}

			if (nowEles.size() > 0 && ctx.judgeCondition((Element) nowEles.get(0), condition)) {
				List tempList = new ArrayList();
				tempList.add((Element) nowEles.get(0));
				ctx.setPreEles(tempList);
			}
		}
		String ss[] = null;
		for (Iterator iterator1 = eles.iterator(); iterator1.hasNext();) {
			ReadXmlExpression tempEle = (ReadXmlExpression) iterator1.next();
			ss = tempEle.interpret(ctx);
		}

		return ss;
	}

	public Object clone() {
		ElementExpression obj = null;
		try {
			obj = (ElementExpression) super.clone();
			List objEles = new ArrayList();
			ReadXmlExpression re;
			for (Iterator iterator = eles.iterator(); iterator.hasNext(); objEles.add((ReadXmlExpression) re.clone()))
				re = (ReadXmlExpression) iterator.next();

			obj.setEles(objEles);
		} catch (Exception err) {
			err.printStackTrace();
		}
		return obj;
	}

}
