package com.ydual.xgen.genconf;

import java.util.Map;

import com.ydual.xgen.genconf.vo.GenConfModel;
import com.ydual.xgen.genconf.vo.GenTypeModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
/**
 * 对外程序接口，让外部获取配置管理模块内的数据
 * 提供相应的API
 * @author l8989
 *
 */
public interface GenConfEbi {

	/**
	 * 第一类：x-gen核心框架运行所需要的配置数据Model，每次使用配置
	 * 
	 * @return 核心框架运行所需要的配置数据model
	 */
	public GenConfModel getGenConf();

	/**
	 * 第二类：用户需要生成的所有模块的配置，每个具体功能的配置
	 * 
	 * @return 包含所有需要生成的所有模块的配置数据的Map，key-模块的id，value-相应的模块的配置数据的model
	 */
	public Map<String, ModuleConfModel> getMapModuleConf();
	
	/**
	 * 第三类：外部主题的配置数据，在制作主题的时候配置好
	 * @param moduleconfmodel
	 * @param s
	 * @return
	 */
	public abstract GenTypeModel getThemeGenType(ModuleConfModel moduleconfmodel, String s);

    public abstract String getThemeGenOutTypeClass(ModuleConfModel moduleconfmodel, String s);
	
}
