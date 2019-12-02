package cn.javass.themes.smvcsm.visitors;

import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.template.visitors.TemplateElement;
import com.ydual.xgen.template.visitors.Visitor;
import java.util.Map;

public class ListJspHeadFields implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String voFieldsNames[] = ((ExtendConfModel) moduleConf.getMapExtends()
				.get("voFieldsNames")).getValues();
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < voFieldsNames.length; i++)
			buffer.append((new StringBuilder("<td>")).append(voFieldsNames[i])
					.append("</td>\n\t").toString());

		return buffer.toString();
	}
}
