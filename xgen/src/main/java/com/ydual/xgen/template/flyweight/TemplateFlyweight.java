package com.ydual.xgen.template.flyweight;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
/**
 * ？？
 * @author l8989
 *
 */
public interface TemplateFlyweight {

	public abstract Object replaceProperties(ModuleConfModel moduleconfmodel, Object obj);

	public abstract Object replaceMethods(ModuleConfModel moduleconfmodel, Object obj);

	public abstract Object getRawContent();

}
