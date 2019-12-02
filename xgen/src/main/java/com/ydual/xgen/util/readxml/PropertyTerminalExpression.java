package com.ydual.xgen.util.readxml;

import org.w3c.dom.Element;

/**
 * 组合模式树叶对象
 * @author l8989
 *
 */
public class PropertyTerminalExpression extends ReadXmlExpression {
	
	private String propName;

	public PropertyTerminalExpression(String propName) {
		this.propName = propName;
	}

	public String[] interpret(Context ctx) {
		String ss[] = new String[1];
		Element pEle = (Element) ctx.getPreEles().get(0);
		ss[0] = pEle.getAttribute(propName);
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
