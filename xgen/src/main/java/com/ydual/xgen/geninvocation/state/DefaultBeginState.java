package com.ydual.xgen.geninvocation.state;

import com.ydual.xgen.geninvocation.DefaultGenInvocation;
/**
 * 默认状态
 * @author l8989
 *
 */
public class DefaultBeginState implements State {

	public DefaultBeginState() {
	}

	public void doWork(DefaultGenInvocation ctx) {
		ctx.setState(new GenState());
		ctx.doWork();
	}

}
