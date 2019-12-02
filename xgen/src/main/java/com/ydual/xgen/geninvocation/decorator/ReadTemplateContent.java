package com.ydual.xgen.geninvocation.decorator;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.mediator.CoreMediator;

public class ReadTemplateContent extends GenDecorator {

	public ReadTemplateContent(GenComponent component) {
		super(component);
	}

	public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
		return CoreMediator.getInstance().getTemplateContent(moduleConf, genTypeId);
	}

}
