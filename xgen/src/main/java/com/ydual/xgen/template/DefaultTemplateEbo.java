package com.ydual.xgen.template;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.template.flyweight.TemplateFlyweight;
import com.ydual.xgen.template.flyweight.TemplateFlyweightFactory;
/**
 * 
 * @author l8989
 *
 */
public class DefaultTemplateEbo implements TemplateEbi {
	private ModuleConfModel moduleConf;
	private String genTypeId;
	private Object nowContent;
	private TemplateFlyweight flyweight;

	public DefaultTemplateEbo(ModuleConfModel moduleConf, String genTypeId) {
		flyweight = null;
		this.moduleConf = moduleConf;
		this.genTypeId = genTypeId;
		flyweight = TemplateFlyweightFactory.getInstance().getTemplateFlyweight(moduleConf, this.genTypeId);
		nowContent = flyweight.getRawContent();
	}

	public Object replaceProperties() {
		nowContent = flyweight.replaceProperties(moduleConf, nowContent);
		return this;
	}

	public Object replaceMethods() {
		nowContent = flyweight.replaceMethods(moduleConf, nowContent);
		return this;
	}

	public Object getNowContent() {
		return nowContent;
	}

}
