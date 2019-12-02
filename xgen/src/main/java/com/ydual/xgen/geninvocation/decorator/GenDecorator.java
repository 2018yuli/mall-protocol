package com.ydual.xgen.geninvocation.decorator;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
/**
 * 装饰器
 * @author l8989
 *
 */
public class GenDecorator extends GenComponent {

	public GenDecorator(GenComponent component) {
		this.component = component;
	}

	public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
		return component.operation(moduleConf, genTypeId, obj);
	}

	protected GenComponent component;

}
