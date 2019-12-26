package com.ydual.xgen.geninvocation.decorator;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.mediator.CoreMediator;

public class ReplaceProperty extends GenDecorator {

	public ReplaceProperty(GenComponent component) {
		super(component);
	}

	public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
		obj = component.operation(moduleConf, genTypeId, obj);
		return CoreMediator.getInstance().templateReplaceProperties(obj);
	}

}