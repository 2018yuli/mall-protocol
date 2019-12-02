package com.ydual.xgen.dispatch.executechain;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.mediator.CoreMediator;
/**
 * 命令的实际处理者
 * CoreMediator中介者，处理，如果让分发模块直接调用生成模块
 * 可能会导致较强的耦合性，使用中介者模式来解决。
 * 把对象之间的交互全部集中到中介者对象里面
 * @author l8989
 *
 */
public class DefaultHandler extends GenHandler {

	private String needGenType = "";

	public DefaultHandler(String needGenType) {
		this.needGenType = needGenType;
	}

	public void handleRequest(ModuleConfModel mcm) {
		CoreMediator.getInstance().needProxyGen(needGenType, mcm);
		super.handleRequest(mcm);
	}

}
