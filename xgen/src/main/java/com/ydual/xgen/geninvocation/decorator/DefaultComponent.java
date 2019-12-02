package com.ydual.xgen.geninvocation.decorator;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
/**
 * 组件
 * @author l8989
 *
 */
public class DefaultComponent extends GenComponent {

	public DefaultComponent() {
	}

	public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
		return obj;
	}

}
