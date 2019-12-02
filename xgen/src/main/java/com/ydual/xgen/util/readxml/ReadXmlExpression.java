package com.ydual.xgen.util.readxml;

/**
 * 组合模式
 * 客户端不再区分操作的是组合对象还是叶子对象
 * 
 * @author l8989
 *
 */
public abstract class ReadXmlExpression implements Cloneable {


    public ReadXmlExpression()
    {
    }

    public abstract String[] interpret(Context context);

    public Object clone()
    {
        Object obj = null;
        try
        {
            obj = super.clone();
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        return obj;
    }

}
