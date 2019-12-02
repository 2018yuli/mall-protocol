package com.ydual.xgen.dispatch.executechain;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
/**
 * 责任链，successor下一个执行者
 * 将这些对象连成一条链，并沿着这条链传递该请求，知道有一个对象处理它为止
 * 解耦请求者和具体接收者，动态切换和组合接收者
 * 
 * @author l8989
 *
 */
public class GenHandler {

	protected GenHandler successor;

	public GenHandler() {
	}

	public void setSuccessor(GenHandler successor) {
		this.successor = successor;
	}

	public void handleRequest(ModuleConfModel mcm) {
		if (successor != null)
			successor.handleRequest(mcm);
	}

}
