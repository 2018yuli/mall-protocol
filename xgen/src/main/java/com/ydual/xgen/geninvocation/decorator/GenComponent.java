package com.ydual.xgen.geninvocation.decorator;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
/**
 * 装饰组件
 * @author l8989
 *
 */
public abstract class GenComponent {
	
	public GenComponent() {
	}

	public abstract Object operation(ModuleConfModel moduleconfmodel, String s, Object obj);
}
