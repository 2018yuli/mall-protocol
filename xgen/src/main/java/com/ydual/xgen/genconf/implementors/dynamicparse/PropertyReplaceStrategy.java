package com.ydual.xgen.genconf.implementors.dynamicparse;

import java.util.Map;

import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.GenConfModel;

public class PropertyReplaceStrategy implements ParseStrategy {


    public PropertyReplaceStrategy()
    {
    }

    public String parseDynamicContent(GenConfModel gm, Map mapEcms, String expr)
    {
        String retStr = "";
        ExtendConfModel ecm = (ExtendConfModel)mapEcms.get(expr);
        if(ecm != null)
            retStr = ecm.getValue();
        return retStr;
    }

}
