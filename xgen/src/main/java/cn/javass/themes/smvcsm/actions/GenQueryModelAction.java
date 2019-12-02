package cn.javass.themes.smvcsm.actions;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.geninvocation.BaseGenAction;
import com.ydual.xgen.geninvocation.decorator.GenComponent;

public class GenQueryModelAction extends BaseGenAction {

	public Object executeDecorators(ModuleConfModel moduleConf, Object obj,
			GenComponent gc) {
		return gc.operation(moduleConf, "GenQueryModel", obj);
	}

	public Object initObject() {
		return "";
	}

	public Object execute(ModuleConfModel moduleConf, Object obj) {
		return obj;
	}

	public GenComponent beforeAction(ModuleConfModel moduleConf) {
		return super.defaultBeforeAction(moduleConf);
	}
}
