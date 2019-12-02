package com.ydual.xgen.geninvocation;

import java.util.Observable;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.geninvocation.state.DefaultBeginState;
import com.ydual.xgen.geninvocation.state.State;
/**
 * 生成工厂
 * 同时也是发布者（推）
 * @author l8989
 *
 */
public class DefaultGenInvocation extends Observable implements GenInvocation {

	private State state;
	private String needGenType;
	private ModuleConfModel moduleConf;
	private Object tempContent;

	public DefaultGenInvocation(String needGenType, ModuleConfModel moduleConf) {
		state = null;
		this.needGenType = "";
		tempContent = null;
		this.needGenType = needGenType;
		this.moduleConf = moduleConf;
	}

	public void doWork() {
		state.doWork(this);
	}

	public void executeGen() {
		state = new DefaultBeginState();
		state.doWork(this);
	}

	public void setContentOver(Object obj) {
		setChanged();
		notifyObservers(obj);
	}

	public String getNeedGenType() {
		return needGenType;
	}

	public ModuleConfModel getModuleConf() {
		return moduleConf;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Object getTempContent() {
		return tempContent;
	}

	public void setTempContent(Object tempContent) {
		this.tempContent = tempContent;
	}

}
