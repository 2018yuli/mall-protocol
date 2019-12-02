package com.ydual.xgen.genconf.implementors.xmlimpl;

import com.ydual.xgen.genconf.constants.ThemeEnum;
/**
 * 构造器
 * @author l8989
 *
 */
public class ThemeBuilder extends CommonBuilder {

	private StringBuffer buffer;

	public ThemeBuilder() {
		buffer = new StringBuffer();
	}

	public ThemeBuilder addTheme() {
		buffer.append(ThemeEnum.Theme);
		return this;
	}

	public ThemeBuilder addGenTypes() {
		buffer.append(ThemeEnum.GenTypes);
		return this;
	}

	public ThemeBuilder addGenType() {
		buffer.append(ThemeEnum.GenType);
		return this;
	}

	public ThemeBuilder addParams() {
		buffer.append(ThemeEnum.Params);
		return this;
	}

	public ThemeBuilder addParam() {
		buffer.append(ThemeEnum.Param);
		return this;
	}

	public ThemeBuilder addGenOutTypes() {
		buffer.append(ThemeEnum.GenOutTypes);
		return this;
	}

	public ThemeBuilder addGenOutType() {
		buffer.append(ThemeEnum.GenOutType);
		return this;
	}

	public ThemeBuilder addProviders() {
		buffer.append(ThemeEnum.Providers);
		return this;
	}

	public ThemeBuilder addProvider() {
		buffer.append(ThemeEnum.Provider);
		return this;
	}

	public ThemeBuilder addType() {
		buffer.append(ThemeEnum.type);
		return this;
	}

	protected StringBuffer getBuilderBuffer() {
		return buffer;
	}

	protected ThemeBuilder getBuilderClassInstance() {
		return this;
	}

}
