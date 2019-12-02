package com.ydual.xgen.genconf.implementors.xmlimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ydual.xgen.genconf.constants.ExpressionEnum;
import com.ydual.xgen.genconf.implementors.GenConfImplementor;
import com.ydual.xgen.genconf.implementors.ThemeImplementer;
import com.ydual.xgen.genconf.vo.NeedGenModel;
import com.ydual.xgen.genconf.vo.ThemeModel;
import com.ydual.xgen.util.readxml.Context;
import com.ydual.xgen.util.readxml.Parser;
import com.ydual.xgen.util.readxml.ReadXmlExpression;

public class GenConfXmlImpl implements GenConfImplementor {


    public GenConfXmlImpl()
    {
    }

    public List getNeedGens()
    {
        return readNeedGends();
    }

    public List getThemes()
    {
        return readThemes();
    }

    public Map getMapConstants()
    {
        return readMapConstants();
    }

    private Context getContext()
    {
        Context c = null;
        try
        {
            c = Context.getInstance(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addXmlFilePre()).addGenConf().addDot()).addXml()).build());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return c;
    }

    private Map readMapConstants()
    {
        Map map = new HashMap();
        Context c = getContext();
        String ids[] = parseConstantIds(c);
        String values[] = parseConstantValues(c);
        for(int i = 0; i < ids.length; i++)
            map.put(ids[i], values[i]);

        return map;
    }

    private String[] parseConstantValues(Context c)
    {
        c.init();
        ReadXmlExpression re = Parser.parse(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addConstants().addSeparator()).addConstant().addDollar()).build());
        return re.interpret(c);
    }

    private String[] parseConstantIds(Context c)
    {
        c.init();
        ReadXmlExpression re = Parser.parse(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addConstants().addSeparator()).addConstant().addDollar()).addDot()).addId()).addDollar()).build());
        return re.interpret(c);
    }

    private List readThemes()
    {
        List retList = new ArrayList();
        Context c = getContext();
        String ids[] = parseThemeIds(c);
        String locations[] = parseThemeLocations(c);
        for(int i = 0; i < ids.length; i++)
        {
            ThemeModel tm = new ThemeModel();
            ThemeImplementer themeImpl = new ThemeXmlImpl();
            Map params = new HashMap();
            params.put(ExpressionEnum.location.getExpr(), locations[i]);
            tm.setId(ids[i]);
            tm.setLocation(locations[i]);
            tm.setMapGenOutTypes(themeImpl.getMapGenOutTypes(ids[i], params));
            tm.setMapGenTypes(themeImpl.getMapGenTypes(ids[i], params));
            tm.setMapProviders(themeImpl.getMapProviders(ids[i], params));
            retList.add(tm);
        }

        return retList;
    }

    private String[] parseThemeLocations(Context c)
    {
        c.init();
        ReadXmlExpression re = Parser.parse(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addThemes().addSeparator()).addTheme().addDollar()).build());
        return re.interpret(c);
    }

    private String[] parseThemeIds(Context c)
    {
        c.init();
        ReadXmlExpression re = Parser.parse(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addThemes().addSeparator()).addTheme().addDollar()).addDot()).addId()).addDollar()).build());
        return re.interpret(c);
    }

    private List readNeedGends()
    {
        List retList = new ArrayList();
        Context c = getContext();
        String needGenIds[] = parseNeedGenIds(c);
        String needGenProviders[] = parseNeedGenProviders(c);
        String needGenThemes[] = parseNeedGenThemes(c);
        for(int i = 0; i < needGenIds.length; i++)
        {
            NeedGenModel ngm = new NeedGenModel();
            ngm.setId(needGenIds[i]);
            ngm.setProvider(needGenProviders[i]);
            ngm.setTheme(needGenThemes[i]);
            String paramIds[] = parseParamIds(c, ngm.getId());
            String paramValues[] = parseParamValues(c, ngm.getId());
            Map mapParams = new HashMap();
            for(int j = 0; j < paramIds.length; j++)
                mapParams.put(paramIds[j], paramValues[j]);

            ngm.setMapParams(mapParams);
            retList.add(ngm);
        }

        return retList;
    }

    private String[] parseParamValues(Context c, String needGenId)
    {
        c.init();
        ReadXmlExpression re = Parser.parse(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator()).addNeedGen().addDollar()).addOpenBracket()).addId()).addEqual()).addOtherValue(needGenId)).addCloseBracket()).addSeparator()).addParams().addDollar()).addSeparator()).addParam().addDollar()).build());
        return re.interpret(c);
    }

    private String[] parseParamIds(Context c, String needGenId)
    {
        c.init();
        ReadXmlExpression re = Parser.parse(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator()).addNeedGen().addDollar()).addOpenBracket()).addId()).addEqual()).addOtherValue(needGenId)).addCloseBracket()).addSeparator()).addParams().addDollar()).addSeparator()).addParam().addDollar()).addDot()).addId()).addDollar()).build());
        return re.interpret(c);
    }

    private String[] parseNeedGenThemes(Context c)
    {
        c.init();
        ReadXmlExpression re = Parser.parse(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator()).addNeedGen().addDollar()).addDot()).addThemeId().addDollar()).build());
        return re.interpret(c);
    }

    private String[] parseNeedGenProviders(Context c)
    {
        c.init();
        ReadXmlExpression re = Parser.parse(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator()).addNeedGen().addDollar()).addDot()).addProvider().addDollar()).build());
        return re.interpret(c);
    }

    private String[] parseNeedGenIds(Context c)
    {
        c.init();
        ReadXmlExpression re = Parser.parse(((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator()).addNeedGen().addDollar()).addDot()).addId()).addDollar()).build());
        return re.interpret(c);
    }

}
