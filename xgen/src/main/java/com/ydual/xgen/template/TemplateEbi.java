package com.ydual.xgen.template;
/**
 * 模板的基本功能
 * @author l8989
 *
 */
public interface TemplateEbi {

	public abstract Object replaceProperties();

	public abstract Object replaceMethods();

	public abstract Object getNowContent();

}
