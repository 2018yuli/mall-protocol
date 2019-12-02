package com.ydual.xgen.genconf.implementors.dynamicparse;

import java.util.Map;

import com.ydual.xgen.genconf.vo.GenConfModel;

import bsh.Interpreter;

public class BeanShellStrategy implements ParseStrategy{


    public BeanShellStrategy()
    {
    }

    public String parseDynamicContent(GenConfModel gm, Map mapEcms, String expr)
    {
        Interpreter interpreter = new Interpreter();
        String retStr = "";
        try
        {
            interpreter.set("gm", gm);
            interpreter.set("mapEcms", mapEcms);
            interpreter.eval((new StringBuilder("retValue=")).append(expr).toString());
            retStr = interpreter.get("retValue").toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return retStr;
    }

}
