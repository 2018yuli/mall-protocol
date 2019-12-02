package com.ydual.xgen.genconf.implementors;

import java.util.Map;

import com.ydual.xgen.genconf.vo.GenConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;

public interface ModuleGenConfImplementor {


    public abstract ModuleConfModel getBaseModuleConfModel(Map map);

    public abstract Map getMapNeedGenTypes(Map map);

    public abstract Map getMapExtends(GenConfModel genconfmodel, Map map);

}
