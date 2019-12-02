package com.ydual.xgen.dispatch.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ydual.xgen.dispatch.executechain.DefaultHandler;
import com.ydual.xgen.dispatch.executechain.GenHandler;
import com.ydual.xgen.genconf.vo.ModuleConfModel;

/**
 * 空命令，调度配置中的所有ModuleConfModel.NeedGenTypes依次处理
 * DefaultCommand组合DefaultHandler
 * @author l8989
 *
 */
public class DefaultCommand implements GenCommand {

	private ModuleConfModel moduleConf;

	public DefaultCommand(ModuleConfModel moduleConf) {
		this.moduleConf = moduleConf;
	}

	/**
	 * 组合命令和执行者以及执行者的下一个执行者
	 */
	public void execute() {
		List listNeedGenTypes = new ArrayList();
		String s;
		for (Iterator iterator = moduleConf.getMapNeedGendTypes().keySet().iterator(); iterator
				.hasNext(); listNeedGenTypes.add(s))
			s = (String) iterator.next();

		Map mapHandler = new HashMap();
		for (int i = 0; i < listNeedGenTypes.size(); i++)
			mapHandler.put(Integer.valueOf(i + 1), new DefaultHandler((String)listNeedGenTypes.get(i)));

		GenHandler h1 = (GenHandler) mapHandler.get(Integer.valueOf(1));
		for (int i = 1; i < mapHandler.values().size(); i++)
			((GenHandler) mapHandler.get(Integer.valueOf(i)))
					.setSuccessor((GenHandler) mapHandler.get(Integer.valueOf(i + 1)));

		h1.handleRequest(moduleConf);
	}

}
