package com.ydual.xgen.template.visitors;

import com.ydual.xgen.genconf.vo.ModuleConfModel;

public class TemplateElement {
	private ModuleConfModel moduleConf;

	public TemplateElement(ModuleConfModel moduleConf) {
		this.moduleConf = moduleConf;
	}

	public Object accept(Visitor v) {
		return v.visitTemplateElement(this);
	}

	public ModuleConfModel getModuleConf() {
		return moduleConf;
	}

}
