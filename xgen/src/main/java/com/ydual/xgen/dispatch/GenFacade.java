package com.ydual.xgen.dispatch;

import java.util.Iterator;

import com.ydual.xgen.dispatch.command.CmdInvoker;
import com.ydual.xgen.dispatch.command.DefaultCommand;
import com.ydual.xgen.dispatch.command.GenCommand;
import com.ydual.xgen.genconf.implementors.GenConfImplementor;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.mediator.CoreMediator;
/**
 * 门面
 * @author l8989
 *
 */
public class GenFacade {


    private GenFacade()
    {
    }

    /**
     * 提供一个默认的，无参的“接口”，表明一切按照配置文件进行生成
     */
    public static void generate()
    {
        generate(CoreMediator.getInstance().getDefaultGenConfProvider());
    }

    /**
     * 按照生成配置来“组合”需要生成的功能 ModuleConfModel
     * @param provider
     */
    public static void generate(GenConfImplementor provider)
    {
        ModuleConfModel mcm;
        for(Iterator iterator = CoreMediator.getInstance().getNeedGenModuleConf(provider).iterator(); iterator.hasNext(); genOneModule(mcm))
            mcm = (ModuleConfModel)iterator.next();

    }

    /**
     * CmdInvoker发出执行生成的“命令”GenCommand
     * GenCommand使用DefaultHandler执行
     * @param mcm
     */
    private static void genOneModule(ModuleConfModel mcm)
    {
        CmdInvoker invoker = new CmdInvoker();
        invoker.setCmd(new DefaultCommand(mcm));
        invoker.doCommand();
    }

}
