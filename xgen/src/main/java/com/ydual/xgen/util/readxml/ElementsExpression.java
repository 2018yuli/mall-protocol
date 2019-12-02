package com.ydual.xgen.util.readxml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Element;
/**
 * 组合模式树枝对象
 * @author l8989
 *
 */
public class ElementsExpression extends ReadXmlExpression {
	private List eles;
	private String eleName;
	private String condition;

	public void setEles(List eles) {
		this.eles = eles;
	}

	public List getEles() {
		return eles;
	}

	public ElementsExpression(String eleName, String condition) {
		eles = new ArrayList();
		this.eleName = "";
		this.condition = "";
		this.eleName = eleName;
		this.condition = condition;
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
		List nowEles = new ArrayList();
		Element pEle;
		for (Iterator iterator = pEles.iterator(); iterator.hasNext(); nowEles.addAll(ctx.getNowEles(pEle, eleName)))
			pEle = (Element) iterator.next();

		for (Iterator it = nowEles.iterator(); it.hasNext();) {
			Element ele = (Element) it.next();
			if (!ctx.judgeCondition(ele, condition))
				it.remove();
		}

		ctx.setPreEles(nowEles);
		String ss[] = null;
		for (Iterator iterator1 = eles.iterator(); iterator1.hasNext();) {
			ReadXmlExpression tempEle = (ReadXmlExpression) iterator1.next();
			ss = tempEle.interpret(ctx);
		}

		return ss;
	}

	public Object clone() {
		ElementsExpression obj = null;
		try {
			obj = (ElementsExpression) super.clone();
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
