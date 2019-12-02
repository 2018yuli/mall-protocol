


// Source File Name:   VoProperty.java

package cn.javass.themes.ssh3.visitors;

import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.template.visitors.TemplateElement;
import com.ydual.xgen.template.visitors.Visitor;
import java.util.Map;

public class VoProperty
    implements Visitor
{

    public VoProperty()
    {
    }

    public Object visitTemplateElement(TemplateElement element)
    {
        ModuleConfModel moduleConf = element.getModuleConf();
        String voFields[] = ((ExtendConfModel)moduleConf.getMapExtends().get("voFields")).getValues();
        String voFieldsTypes[] = ((ExtendConfModel)moduleConf.getMapExtends().get("voFieldsTypes")).getValues();
        StringBuffer buffer = new StringBuffer("");
        for(int i = 0; i < voFields.length; i++)
            buffer.append((new StringBuilder("private ")).append(voFieldsTypes[i]).append(" ").append(voFields[i]).append(";\n\t").toString());

        return buffer.toString();
    }
}
