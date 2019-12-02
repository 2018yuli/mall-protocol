package cn.javass.themes.smvcsm.visitors;

import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.template.visitors.TemplateElement;
import com.ydual.xgen.template.visitors.Visitor;
import java.util.Map;

public class QueryJspJson implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String voFields[] = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"voFields")).getValues();
		StringBuffer buffer = new StringBuffer("var json ='{");

		for (int i = 0; i < voFields.length; i++){
			if(i==0){
				buffer.append("\""+voFields[i]+"\":\"'+$(\"#"+voFields[i]+"\").val()+'\"");
			}else{
				buffer.append(",\""+voFields[i]+"\":\"'+$(\"#"+voFields[i]+"\").val()+'\"");
			}
		}
		buffer.append("}';");
		return buffer.toString();
	}
}
