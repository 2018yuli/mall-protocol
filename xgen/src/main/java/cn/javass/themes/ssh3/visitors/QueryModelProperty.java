


// Source File Name:   QueryModelProperty.java

package cn.javass.themes.ssh3.visitors;

import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.template.visitors.TemplateElement;
import com.ydual.xgen.template.visitors.Visitor;
import java.util.Map;

public class QueryModelProperty
    implements Visitor
{

    public QueryModelProperty()
    {
    }

    public Object visitTemplateElement(TemplateElement element)
    {
        ModuleConfModel moduleConf = element.getModuleConf();
        String voFields[] = ((ExtendConfModel)moduleConf.getMapExtends().get("qmVoFields")).getValues();
        String voFieldsTypes[] = ((ExtendConfModel)moduleConf.getMapExtends().get("qmVoFieldsTypes")).getValues();
        StringBuffer buffer = new StringBuffer("");
        for(int i = 0; i < voFields.length; i++)
            if(voFields[i] != null && voFields[i].trim().length() != 0)
                buffer.append((new StringBuilder("private ")).append(voFieldsTypes[i]).append(" ").append(voFields[i]).append(";\n\t").toString());

        return buffer.toString();
    }
}
