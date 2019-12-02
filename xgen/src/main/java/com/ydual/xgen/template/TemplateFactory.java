package com.ydual.xgen.template;

import com.ydual.xgen.genconf.vo.ModuleConfModel;

public class TemplateFactory {

    private TemplateFactory()
    {
    }

    public static TemplateEbi createTemplateEbi(ModuleConfModel moduleConf, String genTypeId)
    {
        return new DefaultTemplateEbo(moduleConf, genTypeId);
    }

}
