package com.ydual.xgen.genconf.confmanger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ydual.xgen.genconf.implementors.GenConfImplementor;
import com.ydual.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.ydual.xgen.genconf.vo.GenConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.genconf.vo.NeedGenModel;
/**
 * 抽象工厂(桥接模式)
 * genConf包括 核心配置，多个模块配置，外部主题的配置等组件
 * @author l8989
 *
 */
public class ConfManager {
	
	private static ConfManager manager = null;
	private GenConfModel genConf;
	private Map mapModuleConf;

	private ConfManager(GenConfImplementor provider) {
		genConf = new GenConfModel();
		mapModuleConf = new HashMap();
		readConf(provider);
	}

	public static ConfManager getInstance(GenConfImplementor provider) {
		if (manager == null)
			manager = new ConfManager(provider);
		return manager;
	}

	public GenConfModel getGenConf() {
		return genConf;
	}

	public Map getMapModuleConf() {
		return mapModuleConf;
	}

	private void readConf(GenConfImplementor provider) {
		readGenConf(provider);
		NeedGenModel ngm;
		for (Iterator iterator = genConf.getNeedGens().iterator(); iterator.hasNext(); readOneModuleGenConf(ngm))
			ngm = (NeedGenModel) iterator.next();

	}

	private void readOneModuleGenConf(NeedGenModel ngm) {
		ModuleConfModel mcm = new ModuleConfModel();
		String providerClassName = (String) genConf.getThemeById(ngm.getTheme()).getMapProviders()
				.get(ngm.getProvider());
		ModuleGenConfImplementor userGenConfImpl = null;
		try {
			userGenConfImpl = (ModuleGenConfImplementor) Class.forName(providerClassName).newInstance();
		} catch (Exception err) {
			err.printStackTrace();
		}
		mcm = userGenConfImpl.getBaseModuleConfModel(ngm.getMapParams());
		mcm.setUseTheme(ngm.getTheme());
		mcm.setMapNeedGendTypes(userGenConfImpl.getMapNeedGenTypes(ngm.getMapParams()));
		mcm.setMapExtends(userGenConfImpl.getMapExtends(genConf, ngm.getMapParams()));
		mapModuleConf.put(mcm.getModuleId(), mcm);
	}

	private void readGenConf(GenConfImplementor provider) {
		genConf.setNeedGens(provider.getNeedGens());
		genConf.setThemes(provider.getThemes());
		genConf.setMapConstants(provider.getMapConstants());
	}

}
