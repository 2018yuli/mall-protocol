package com.ydual.xgen.output.types.outputtofile;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
/**
 * 输出路径组件接口
 * @author l8989
 *
 */
public interface GenOutPathPackages {

	public abstract boolean genPackages(ModuleConfModel moduleconfmodel, String s);

	public abstract String getOutPathAndFileName(ModuleConfModel moduleconfmodel, String s);

}
