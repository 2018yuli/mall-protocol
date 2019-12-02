package com.ydual.xgen.template.visitors;
/**
 * 外部Theme里面真正的实现Visitor
 * @author l8989
 *
 */
public interface Visitor {

    public abstract Object visitTemplateElement(TemplateElement templateelement);

}
