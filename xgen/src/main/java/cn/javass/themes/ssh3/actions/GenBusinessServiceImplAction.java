


// Source File Name:   GenBusinessServiceImplAction.java

package cn.javass.themes.ssh3.actions;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.geninvocation.BaseGenAction;
import com.ydual.xgen.geninvocation.decorator.GenComponent;

public class GenBusinessServiceImplAction extends BaseGenAction
{

    public GenBusinessServiceImplAction()
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
        return gc.operation(moduleConf, "GenBusinessServiceImpl", obj);
    }

    public GenComponent beforeAction(ModuleConfModel moduleConf)
    {
        return super.defaultBeforeAction(moduleConf);
    }
}
