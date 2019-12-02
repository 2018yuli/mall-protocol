package com.ydual.xgen.geninvocation.state;

import com.ydual.xgen.geninvocation.BaseGenAction;
import com.ydual.xgen.geninvocation.DefaultGenInvocation;
import com.ydual.xgen.mediator.CoreMediator;
/**
 * 生成中
 * @author l8989
 *
 */
public class GenState implements State {

	public GenState() {
	}

	public void doWork(DefaultGenInvocation ctx) {
		String className = CoreMediator.getInstance().getNeedGenTypeClass(ctx.getNeedGenType(), ctx.getModuleConf());
		Object obj = null;
		try {
			obj = ((BaseGenAction) Class.forName(className).newInstance()).generate(ctx.getModuleConf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.setTempContent(obj);
		ctx.setState(new OutState());
		ctx.doWork();
	}

}
