


// Source File Name:   ListJspValueFields.java

package cn.javass.themes.ssh3.visitors;

import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.template.visitors.TemplateElement;
import com.ydual.xgen.template.visitors.Visitor;
import java.util.Map;

public class ListJspValueFields
    implements Visitor
{

    public ListJspValueFields()
    {
    }

    public Object visitTemplateElement(TemplateElement element)
    {
        ModuleConfModel moduleConf = element.getModuleConf();
        String voFields[] = ((ExtendConfModel)moduleConf.getMapExtends().get("voFields")).getValues();
        String moduleName = ((ExtendConfModel)moduleConf.getMapExtends().get("moduleName")).getValue();
        StringBuffer buffer = new StringBuffer("");
        for(int i = 0; i < voFields.length; i++)
            buffer.append((new StringBuilder("<td>${")).append(voFields[i]).append("}</td>\n\t").toString());

        buffer.append("<td>\n\t");
        buffer.append((new StringBuilder("<a href=\"${pageContext.request.contextPath}/")).append(moduleName).append("!toUpdate.action?m.uuid=${uuid}\">\uFFFD\u07B8\uFFFD </a> |\n\t").toString());
        buffer.append((new StringBuilder("<a href=\"${pageContext.request.contextPath}/")).append(moduleName).append("!toDelete.action?m.uuid=${uuid}\">\u027E\uFFFD\uFFFD</a>\n").toString());
        buffer.append("</td>\n");
        return buffer.toString();
    }
}
