package com.ydual.xgen.template.flyweight;

import java.util.HashMap;
import java.util.Map;

import com.ydual.xgen.genconf.constants.ExpressionEnum;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.mediator.CoreMediator;
import com.ydual.xgen.util.file.FileHelper;
/**
 * 
 * @author l8989
 *
 */
public class TemplateFlyweightFactory {

	private static TemplateFlyweightFactory factory = new TemplateFlyweightFactory();
	Map mapTemplate;

	private TemplateFlyweightFactory() {
		mapTemplate = new HashMap();
	}

	public static TemplateFlyweightFactory getInstance() {
		return factory;
	}

	public DefaultTemplate getTemplateFlyweight(String templatePath) {
		Object obj = mapTemplate.get(templatePath);
		if (obj == null) {
			DefaultTemplate dt = new DefaultTemplate(FileHelper.readFile(templatePath));
			mapTemplate.put(templatePath, dt);
			return dt;
		} else {
			return (DefaultTemplate) obj;
		}
	}

	public DefaultTemplate getTemplateFlyweight(ModuleConfModel moduleConf, String genTypeId) {
		String mbPathFile = CoreMediator.getInstance().getThemeMbPathFile(moduleConf, genTypeId);
		String themePath = CoreMediator.getInstance().getThemePath(moduleConf);
		String templatePath = (new StringBuilder(String.valueOf(themePath))).append(ExpressionEnum.separator.getExpr())
				.append(ExpressionEnum.template.getExpr()).append(ExpressionEnum.separator.getExpr()).append(mbPathFile)
				.toString();
		return getTemplateFlyweight(templatePath);
	}

}
