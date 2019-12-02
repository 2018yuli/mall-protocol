package com.ydual.xgen.template.flyweight;

import com.ydual.xgen.genconf.constants.ExpressionEnum;
import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.template.visitors.TemplateElement;
import com.ydual.xgen.template.visitors.Visitor;
/**
 * 
 * @author l8989
 *
 */
public class DefaultTemplate implements TemplateFlyweight {

	private String rawContent = "";

	DefaultTemplate(String rawContent) {
		this.rawContent = rawContent;
	}

	public Object replaceProperties(ModuleConfModel moduleConf, Object content) {
		return nowReplaceProperties(moduleConf, content);
	}

	public Object replaceMethods(ModuleConfModel moduleConf, Object content) {
		return nowReplaceMethods(moduleConf, content);
	}

	public Object getRawContent() {
		return rawContent;
	}

	private Object nowReplaceMethods(ModuleConfModel moduleConf, Object content) {
		String templateContent = (String) content;
		int begin = templateContent.indexOf(ExpressionEnum.methodBeginStr.getExpr());
		if (begin >= 0) {
			int end = begin + ExpressionEnum.methodBeginStr.getExpr().length()
					+ templateContent.substring(begin + ExpressionEnum.methodBeginStr.getExpr().length())
							.indexOf(ExpressionEnum.methodEndStr.getExpr());
			String className = templateContent.substring(begin + ExpressionEnum.methodBeginStr.getExpr().length(), end);
			String methodValue = (new StringBuilder()).append(callMethodVisitor(className, moduleConf)).toString();
			templateContent = templateContent
					.replace(
							(new StringBuilder(String.valueOf(ExpressionEnum.methodBeginStr.getExpr())))
									.append(className).append(ExpressionEnum.methodEndStr.getExpr()).toString(),
							methodValue);
			templateContent = (new StringBuilder()).append(nowReplaceMethods(moduleConf, templateContent)).toString();
		}
		return templateContent;
	}

	private Object callMethodVisitor(String className, ModuleConfModel moduleConf) {
		Object ret = null;
		try {
			Visitor v = (Visitor) Class.forName(className).newInstance();
			TemplateElement element = new TemplateElement(moduleConf);
			ret = element.accept(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	private Object nowReplaceProperties(ModuleConfModel moduleConf, Object content) {
		String templateContent = (String) content;
		int begin = templateContent.indexOf(ExpressionEnum.propBeginStr.getExpr());
		if (begin >= 0) {
			int end = begin + ExpressionEnum.propBeginStr.getExpr().length()
					+ templateContent.substring(begin + ExpressionEnum.propBeginStr.getExpr().length())
							.indexOf(ExpressionEnum.propEndStr.getExpr());
			String prop = templateContent.substring(begin + ExpressionEnum.propBeginStr.getExpr().length(), end);
			String propValue = "";
			try {
				propValue = ((ExtendConfModel) moduleConf.getMapExtends().get(prop)).getValue();
			} catch (Exception err) {
				System.out.println(
						(new StringBuilder("\u8BF7\u68C0\u67E5\u5C5E\u6027===")).append(prop).append("\n").toString());
				throw new RuntimeException(err);
			}
			templateContent = templateContent
					.replace((new StringBuilder(String.valueOf(ExpressionEnum.propBeginStr.getExpr()))).append(prop)
							.append(ExpressionEnum.propEndStr.getExpr()).toString(), propValue);
			templateContent = (new StringBuilder()).append(nowReplaceProperties(moduleConf, templateContent))
					.toString();
		}
		return templateContent;
	}

}
