package com.ydual.xgen.genconf.implementors.xmlimpl;

import java.util.HashMap;
import java.util.Map;

import com.ydual.xgen.genconf.constants.ExpressionEnum;
import com.ydual.xgen.genconf.implementors.ThemeImplementer;
import com.ydual.xgen.genconf.vo.GenTypeModel;
import com.ydual.xgen.util.readxml.Context;
import com.ydual.xgen.util.readxml.Parser;
import com.ydual.xgen.util.readxml.ReadXmlExpression;


public class ThemeXmlImpl implements ThemeImplementer {

	public ThemeXmlImpl() {
	}

	public Map getMapGenTypes(String themeId, Map param) {
		Map map = new HashMap();
		String genTypeIds[] = parseGenTypeIds(getContext(param));
		String genTypeValues[] = parseGenTypeValues(getContext(param));
		for (int i = 0; i < genTypeIds.length; i++) {
			GenTypeModel gtm = new GenTypeModel();
			gtm.setGenTypeClass(genTypeValues[i]);
			gtm.setId(genTypeIds[i]);
			String paramIds[] = parseGenTypeParamIds(getContext(param), gtm.getId());
			String paramValues[] = parseGenTypeParamValues(getContext(param), gtm.getId());
			Map paramMap = new HashMap();
			for (int j = 0; j < paramIds.length; j++)
				paramMap.put(paramIds[j], paramValues[j]);

			gtm.setMapParams(paramMap);
			map.put(gtm.getId(), gtm);
		}

		return map;
	}

	public Map getMapGenOutTypes(String themeId, Map param) {
		Map map = new HashMap();
		String genOutTypeIds[] = parseOutTypeIds(getContext(param));
		String genOutTypeValues[] = parseOutTypeValues(getContext(param));
		for (int i = 0; i < genOutTypeIds.length; i++)
			map.put(genOutTypeIds[i], genOutTypeValues[i]);

		return map;
	}

	public Map getMapProviders(String themeId, Map param) {
		Map map = new HashMap();
		String genProviderIds[] = parseProviderIds(getContext(param));
		String genProviderValues[] = parseProviderValues(getContext(param));
		for (int i = 0; i < genProviderIds.length; i++)
			map.put(genProviderIds[i], genProviderValues[i]);

		return map;
	}

	private Context getContext(Map param) {
		Context c = null;
		try {
			c = Context.getInstance(
					(new StringBuilder(String.valueOf((String) param.get(ExpressionEnum.location.getExpr()))))
							.append(ExpressionEnum.separator.getExpr()).append(ExpressionEnum.themeXmlName.getExpr())
							.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	private String[] parseGenTypeParamValues(Context c, String genTypeId) {
		c.init();
		ReadXmlExpression re = Parser.parse(
				((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder())
						.addTheme().addSeparator()).addGenTypes().addSeparator()).addGenType().addDollar())
								.addOpenBracket()).addId()).addEqual()).addOtherValue(genTypeId)).addCloseBracket())
										.addSeparator()).addParams().addSeparator()).addParam().addDollar()).build());
		return re.interpret(c);
	}

	private String[] parseGenTypeParamIds(Context c, String genTypeId) {
		c.init();
		ReadXmlExpression re = Parser.parse(
				((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder())
						.addTheme().addSeparator()).addGenTypes().addSeparator()).addGenType().addDollar())
								.addOpenBracket()).addId()).addEqual()).addOtherValue(genTypeId)).addCloseBracket())
										.addSeparator()).addParams().addSeparator()).addParam().addDollar()).addDot())
												.addId()).addDollar()).build());
		return re.interpret(c);
	}

	private String[] parseGenTypeValues(Context c) {
		c.init();
		ReadXmlExpression re = Parser.parse(
				((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder())
						.addTheme().addSeparator()).addGenTypes().addSeparator()).addGenType().addDollar()).addDot())
								.addType().addDollar()).build());
		return re.interpret(c);
	}

	private String[] parseGenTypeIds(Context c) {
		c.init();
		ReadXmlExpression re = Parser.parse(
				((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder())
						.addTheme().addSeparator()).addGenTypes().addSeparator()).addGenType().addDollar()).addDot())
								.addId()).addDollar()).build());
		return re.interpret(c);
	}

	private String[] parseOutTypeValues(Context c) {
		c.init();
		ReadXmlExpression re = Parser.parse(
				((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder())
						.addTheme().addSeparator()).addGenOutTypes().addSeparator()).addGenOutType().addDollar())
								.addDot()).addType().addDollar()).build());
		return re.interpret(c);
	}

	private String[] parseOutTypeIds(Context c) {
		c.init();
		ReadXmlExpression re = Parser.parse(
				((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder())
						.addTheme().addSeparator()).addGenOutTypes().addSeparator()).addGenOutType().addDollar())
								.addDot()).addId()).addDollar()).build());
		return re.interpret(c);
	}

	private String[] parseProviderValues(Context c) {
		c.init();
		ReadXmlExpression re = Parser.parse(
				((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder())
						.addTheme().addSeparator()).addProviders().addSeparator()).addProvider().addDollar()).addDot())
								.addType().addDollar()).build());
		return re.interpret(c);
	}

	private String[] parseProviderIds(Context c) {
		c.init();
		ReadXmlExpression re = Parser.parse(
				((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder())
						.addTheme().addSeparator()).addProviders().addSeparator()).addProvider().addDollar()).addDot())
								.addId()).addDollar()).build());
		return re.interpret(c);
	}

}
