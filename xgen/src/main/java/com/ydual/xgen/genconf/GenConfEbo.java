package com.ydual.xgen.genconf;

import java.util.Map;

import com.ydual.xgen.genconf.confmanger.ConfManager;
import com.ydual.xgen.genconf.implementors.GenConfImplementor;
import com.ydual.xgen.genconf.vo.GenConfModel;
import com.ydual.xgen.genconf.vo.GenTypeModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;

/**
 * 单例的getInstance
 * 
 * @author l8989
 *
 */
public class GenConfEbo implements GenConfEbi {

	private static GenConfEbo ebo = null;
	private GenConfImplementor provider = null;

	private GenConfEbo(GenConfImplementor provider) {
		this.provider = provider;
	}

	public static GenConfEbi getInstance(GenConfImplementor provider) {
		if (ebo == null) {
			if (provider == null)
				throw new IllegalArgumentException(
						"第一次创建配置对象时，provider不能为空");
			ebo = new GenConfEbo(provider);
		}
		return ebo;
	}

	public GenConfModel getGenConf() {
		return ConfManager.getInstance(provider).getGenConf();
	}

	public Map getMapModuleConf() {
		return ConfManager.getInstance(provider).getMapModuleConf();
	}

	public GenTypeModel getThemeGenType(ModuleConfModel moduleConf, String needGenTypeId) {
		return (GenTypeModel) getGenConf().getThemeById(moduleConf.getUseTheme()).getMapGenTypes().get(needGenTypeId);
	}

	public String getThemeGenOutTypeClass(ModuleConfModel moduleConf, String needGenOutTypeId) {
		return (String) getGenConf().getThemeById(moduleConf.getUseTheme()).getMapGenOutTypes().get(needGenOutTypeId);
	}


}
