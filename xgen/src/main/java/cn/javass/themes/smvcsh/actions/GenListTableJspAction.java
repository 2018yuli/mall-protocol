// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2014-1-28 15:50:52
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!

// Source File Name:   GenListTableJspAction.java

package cn.javass.themes.smvcsh.actions;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.geninvocation.BaseGenAction;
import com.ydual.xgen.geninvocation.decorator.GenComponent;

public class GenListTableJspAction extends BaseGenAction
{

    public GenListTableJspAction()
    {
    }

    public Object initObject()
    {
        return "";
    }

    public Object execute(ModuleConfModel moduleConf, Object obj)
    {
        return obj;
    }

    public Object executeDecorators(ModuleConfModel moduleConf, Object obj, GenComponent gc)
    {
        return gc.operation(moduleConf, "GenListTableJsp", obj);
    }

    public GenComponent beforeAction(ModuleConfModel moduleConf)
    {
        return super.defaultBeforeAction(moduleConf);
    }
}