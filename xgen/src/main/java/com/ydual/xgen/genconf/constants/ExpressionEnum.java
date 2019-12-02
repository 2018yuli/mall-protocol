package com.ydual.xgen.genconf.constants;

public enum ExpressionEnum {

	dot("dot", 0, "."),
	separator("separator", 1, "/"),
	dollar("dollar", 2, "$"),
	openBracket("openBracket", 3, "["),
	closeBracket("closeBracket", 4, "]"),
	equal("equal", 5, "="),
	comma("comma", 6, ","),
	xml("xml", 7, "xml"),
	xmlFilePre("xmlFilePre", 8, "cn/javass/xgenconfxml/"),
	themeXmlName("themeXmlName", 9, "ThemeConf.xml"),
	location("location", 10, "location"),
	fileName("fileName", 11, "fileName"),
	propBeginStr("propBeginStr", 12, "$#"),
	propEndStr("propEndStr", 13, "#"),
	methodBeginStr("methodBeginStr", 14, "$["),
	methodEndStr("methodEndStr", 15, "]"),
	template("template", 16, "template");
	
	// 成员变量  
    private String name;  
	private int index;
	private String expr;
	// 构造方法  
	private ExpressionEnum(String s, int i, String expr) {
		this.name = s;
		this.index = i;
		this.expr = expr;
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}

	public String getExpr() {
		return expr;
	}


}
