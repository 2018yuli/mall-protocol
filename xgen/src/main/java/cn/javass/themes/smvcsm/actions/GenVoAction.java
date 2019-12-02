package cn.javass.themes.smvcsm.actions;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.geninvocation.BaseGenAction;
import com.ydual.xgen.geninvocation.decorator.GenComponent;

public class GenVoAction extends BaseGenAction {
	public Object initObject() {
		return "";
	}

	public Object execute(ModuleConfModel moduleConf, Object obj) {
		return obj;
	}

	public Object executeDecorators(ModuleConfModel moduleConf, Object obj,
			GenComponent gc) {
		return gc.operation(moduleConf, "GenVo", obj);
	}

	public GenComponent beforeAction(ModuleConfModel moduleConf) {
		return super.defaultBeforeAction(moduleConf);
	}
}
