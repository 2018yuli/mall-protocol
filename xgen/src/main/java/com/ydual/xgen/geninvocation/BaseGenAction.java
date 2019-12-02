package com.ydual.xgen.geninvocation;

import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.geninvocation.decorator.DefaultComponent;
import com.ydual.xgen.geninvocation.decorator.GenComponent;
import com.ydual.xgen.geninvocation.decorator.ReadTemplateContent;
import com.ydual.xgen.geninvocation.decorator.ReplaceMethods;
import com.ydual.xgen.geninvocation.decorator.ReplaceProperty;
/**
 * 公用解析，模板方法
 * @author l8989
 *
 */
public abstract class BaseGenAction {


    public BaseGenAction()
    {
    }

    public Object generate(ModuleConfModel moduleConf)
    {
        Object obj = initObject();
        Object before = beforeAction(moduleConf);
        if(before != null)
            obj = executeDecorators(moduleConf, obj, (GenComponent)before);
        beforeAction(moduleConf);
        obj = execute(moduleConf, obj);
        Object after = afterAction(moduleConf);
        if(after != null)
            obj = executeDecorators(moduleConf, obj, (GenComponent)after);
        return obj;
    }

    public abstract Object initObject();

    public GenComponent beforeAction(ModuleConfModel moduleConf)
    {
        return null;
    }

    public abstract Object execute(ModuleConfModel moduleconfmodel, Object obj);

    public GenComponent afterAction(ModuleConfModel moduleConf)
    {
        return null;
    }

    public abstract Object executeDecorators(ModuleConfModel moduleconfmodel, Object obj, GenComponent gencomponent);

    public GenComponent defaultBeforeAction(ModuleConfModel moduleConf)
    {
        GenComponent gc = new DefaultComponent();
        GenComponent d1 = new ReadTemplateContent(gc);
        GenComponent d2 = new ReplaceProperty(d1);
        GenComponent d3 = new ReplaceMethods(d2);
        return d3;
    }

}
