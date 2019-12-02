package com.ydual.xgen.genproxy;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.geninvocation.GenInvocation;
import com.ydual.xgen.mediator.CoreMediator;

public class GenProxyFactory {

	private GenProxyFactory() {
	}

	public static GenInvocation createGenProxy(String needGenType, ModuleConfModel moduleConf) {
		GenInvocation invocation = CoreMediator.getInstance().getDefaultGenInvocation(needGenType, moduleConf);
		return new DefaultProxy(invocation);
	}

}
