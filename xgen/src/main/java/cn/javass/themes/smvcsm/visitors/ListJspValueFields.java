package cn.javass.themes.smvcsm.visitors;

import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.template.visitors.TemplateElement;
import com.ydual.xgen.template.visitors.Visitor;
import java.util.Map;

public class ListJspValueFields implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String voFields[] = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"voFields")).getValues();
		String moduleName = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"moduleName")).getValue();
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < voFields.length; i++)
			buffer.append((new StringBuilder("<td>${m.")).append(voFields[i])
					.append("}</td>\n\t").toString());

		buffer.append("<td>\n\t");
		buffer.append((new StringBuilder(
				"<a href=\"${pageContext.request.contextPath}/"))
				.append(moduleName)
				.append("/toUpdate/${m.uuid}\">修改 </a> |\n\t")
				.toString());
		buffer.append((new StringBuilder(
				"<a href=\"${pageContext.request.contextPath}/"))
				.append(moduleName)
				.append("/toDelete/${m.uuid}\">删除</a>\n")
				.toString());
		buffer.append("</td>\n");
		return buffer.toString();
	}
}
