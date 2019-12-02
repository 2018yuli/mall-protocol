package com.ydual.xgen.genconf.implementors.dynamicparse;

import java.util.Map;

import com.ydual.xgen.genconf.vo.GenConfModel;
/**
 * 策略
 * @author l8989
 *
 */
public interface ParseStrategy {

    public abstract String parseDynamicContent(GenConfModel genconfmodel, Map map, String s);

}
