


// Source File Name:   EntityGetterAndSetter.java

package cn.javass.themes.smvcsh.visitors;

import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.template.visitors.TemplateElement;
import com.ydual.xgen.template.visitors.Visitor;
import java.util.Map;

public class EntityGetterAndSetter
    implements Visitor
{

    public EntityGetterAndSetter()
    {
    }

    public Object visitTemplateElement(TemplateElement element)
    {
        ModuleConfModel moduleConf = element.getModuleConf();
        return genProperties(moduleConf, "voFields", "voFieldsTypes");
    }

    private static String genProperties(ModuleConfModel moduleConf, String fieldsName, String fieldsTypesName)
    {
        String voFields[] = ((ExtendConfModel)moduleConf.getMapExtends().get(fieldsName)).getValues();
        String voFieldsTypes[] = ((ExtendConfModel)moduleConf.getMapExtends().get(fieldsTypesName)).getValues();
        StringBuffer buffer = new StringBuffer("");
        for(int i = 0; i < voFields.length; i++)
        {
            buffer.append((new StringBuilder("public void set")).append(voFields[i].substring(0, 1).toUpperCase()).append(voFields[i].substring(1)).append("(").append(voFieldsTypes[i]).append(" obj){\n\t\t").toString());
            buffer.append((new StringBuilder("this.")).append(voFields[i]).append(" = obj;\n\t").toString());
            buffer.append("}\n\t");
            buffer.append((new StringBuilder("public ")).append(voFieldsTypes[i]).append(" get").append(voFields[i].substring(0, 1).toUpperCase()).append(voFields[i].substring(1)).append("(){\n\t\t").toString());
            buffer.append((new StringBuilder("return this.")).append(voFields[i]).append(";\n\t").toString());
            buffer.append("}\n\t");
            buffer.append("\n\t");
        }

        return buffer.toString();
    }
}
