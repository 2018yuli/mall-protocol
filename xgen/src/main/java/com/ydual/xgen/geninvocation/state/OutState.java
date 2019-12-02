package com.ydual.xgen.geninvocation.state;

import com.ydual.xgen.geninvocation.DefaultGenInvocation;
import com.ydual.xgen.mediator.CoreMediator;
import com.ydual.xgen.template.TemplateEbi;
/**
 * 生成完成状态
 * @author l8989
 *
 */
public class OutState implements State {

	public OutState() {
	}

	public void doWork(DefaultGenInvocation ctx) {
		CoreMediator.getInstance().registerObservers(ctx);
		ctx.setContentOver(((TemplateEbi) ctx.getTempContent()).getNowContent());
	}

}
