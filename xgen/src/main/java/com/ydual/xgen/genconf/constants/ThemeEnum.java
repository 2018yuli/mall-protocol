package com.ydual.xgen.genconf.constants;

public enum ThemeEnum {
	Theme("Theme", 0),
	GenTypes("GenTypes", 1),
	GenType("GenType", 2),
	id("id", 3),
	type("type", 4),
	Params("Params", 5),
	Param("Param", 6),
	GenOutTypes("GenOutTypes", 7),
	GenOutType("GenOutType", 8),
	Providers("Providers", 9),
	Provider("Provider", 10);
	
	// 成员变量  
    private String name;  
	private int index;  
    // 构造方法  
    private ThemeEnum(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }
    
    public String getName() {
		return name;
	}
	public int getIndex() {
		return index;
	}
}
