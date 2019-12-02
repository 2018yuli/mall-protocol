package com.ydual.xgen.genconf;

import com.ydual.xgen.genconf.implementors.GenConfImplementor;
/**
 * 简单工厂
 * 向模块外部提供GenConfEbo的实例，
 * 外部根本不知道模块内部的具体实现（模块内部的配置可以有多种方式来实现）
 * @author l8989
 *
 */
public class GenConfFactory {

	private GenConfFactory() {}
	
	public static GenConfEbi createGenConfEbi(GenConfImplementor provider)
    {
        return GenConfEbo.getInstance(provider);
    }

    public static GenConfEbi createGenConfEbi()
    {
        return createGenConfEbi(null);
    }
}
