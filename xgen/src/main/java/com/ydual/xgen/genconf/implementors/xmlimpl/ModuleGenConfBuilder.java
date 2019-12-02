package com.ydual.xgen.genconf.implementors.xmlimpl;

import com.ydual.xgen.genconf.constants.ModuleGenConfEnum;

public class ModuleGenConfBuilder extends CommonBuilder {

	private StringBuffer buffer;

	public ModuleGenConfBuilder() {
		buffer = new StringBuffer();
	}

	public ModuleGenConfBuilder addModuleGenConf() {
		buffer.append(ModuleGenConfEnum.ModuleGenConf);
		return this;
	}

	public ModuleGenConfBuilder addNeedGenTypes() {
		buffer.append(ModuleGenConfEnum.NeedGenTypes);
		return this;
	}

	public ModuleGenConfBuilder addNeedGenType() {
		buffer.append(ModuleGenConfEnum.NeedGenType);
		return this;
	}

	public ModuleGenConfBuilder addNeedGenOutType() {
		buffer.append(ModuleGenConfEnum.NeedGenOutType);
		return this;
	}

	public ModuleGenConfBuilder addExtendConfs() {
		buffer.append(ModuleGenConfEnum.ExtendConfs);
		return this;
	}

	public ModuleGenConfBuilder addExtendConf() {
		buffer.append(ModuleGenConfEnum.ExtendConf);
		return this;
	}

	public ModuleGenConfBuilder addIsSingle() {
		buffer.append(ModuleGenConfEnum.isSingle);
		return this;
	}

	protected StringBuffer getBuilderBuffer() {
		return buffer;
	}

	protected ModuleGenConfBuilder getBuilderClassInstance() {
		return this;
	}

}
