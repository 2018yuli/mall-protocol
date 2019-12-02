package com.ydual.xgen.genconf.implementors.xmlimpl;

import com.ydual.xgen.genconf.constants.ExpressionEnum;
import com.ydual.xgen.genconf.constants.GenConfEnum;

public abstract class CommonBuilder {

	public CommonBuilder() {
	}

	protected abstract StringBuffer getBuilderBuffer();

	protected abstract Object getBuilderClassInstance();

	public Object addDot() {
		getBuilderBuffer().append(ExpressionEnum.dot.getExpr());
		return getBuilderClassInstance();
	}

	public Object addSeparator() {
		getBuilderBuffer().append(ExpressionEnum.separator.getExpr());
		return getBuilderClassInstance();
	}

	public Object addDollar() {
		getBuilderBuffer().append(ExpressionEnum.dollar.getExpr());
		return getBuilderClassInstance();
	}

	public Object addOpenBracket() {
		getBuilderBuffer().append(ExpressionEnum.openBracket.getExpr());
		return getBuilderClassInstance();
	}

	public Object addCloseBracket() {
		getBuilderBuffer().append(ExpressionEnum.closeBracket.getExpr());
		return getBuilderClassInstance();
	}

	public Object addEqual() {
		getBuilderBuffer().append(ExpressionEnum.equal.getExpr());
		return getBuilderClassInstance();
	}

	public Object addComma() {
		getBuilderBuffer().append(ExpressionEnum.comma.getExpr());
		return getBuilderClassInstance();
	}

	public Object addXml() {
		getBuilderBuffer().append(ExpressionEnum.xml.getExpr());
		return getBuilderClassInstance();
	}

	public Object addXmlFilePre() {
		getBuilderBuffer().append(ExpressionEnum.xmlFilePre.getExpr());
		return getBuilderClassInstance();
	}

	public Object addId() {
		getBuilderBuffer().append(GenConfEnum.id);
		return getBuilderClassInstance();
	}

	public Object addOtherValue(String value) {
		getBuilderBuffer().append(value);
		return getBuilderClassInstance();
	}

	public String build() {
		return getBuilderBuffer().toString();
	}

}
