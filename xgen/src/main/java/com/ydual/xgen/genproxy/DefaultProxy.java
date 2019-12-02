package com.ydual.xgen.genproxy;

import com.ydual.xgen.geninvocation.GenInvocation;
/**
 * 代理模式
 * 控制对象访问
 * 远程代理
 * 虚代理：开销很大
 * 保护代理，控制对原始对象的访问
 * 智能指引代理，访问对象时附加一些操作
 * @author l8989
 *
 */
public class DefaultProxy implements GenInvocation {

	private GenInvocation invocation;

	public DefaultProxy(GenInvocation invocation) {
		this.invocation = null;
		this.invocation = invocation;
	}

	public void executeGen() {
		invocation.executeGen();
	}

}
