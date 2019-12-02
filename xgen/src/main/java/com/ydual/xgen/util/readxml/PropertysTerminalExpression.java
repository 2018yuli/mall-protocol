package com.ydual.xgen.util.readxml;

import java.util.List;

import org.w3c.dom.Element;
/**
 * 组合模式树叶对象
 * @author l8989
 *
 */
public class PropertysTerminalExpression extends ReadXmlExpression {
	
	private String propName;

	public PropertysTerminalExpression(String propName) {
		this.propName = propName;
	}

	public String[] interpret(Context ctx) {
		List pEles = ctx.getPreEles();
		String ss[] = new String[pEles.size()];
		for (int i = 0; i < ss.length; i++)
			ss[i] = ((Element) pEles.get(i)).getAttribute(propName);

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
