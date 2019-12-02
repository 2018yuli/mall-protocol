package com.ydual.xgen.geninvocation;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
/**
 * 工厂方法
 * @author l8989
 *
 */
public class GenInvocationFactory {

	private GenInvocationFactory() {
	}

	public static GenInvocation createGenInvocation(String needGenType, ModuleConfModel moduleConf) {
		return new DefaultGenInvocation(needGenType, moduleConf);
	}

}
