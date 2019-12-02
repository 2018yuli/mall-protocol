package com.ydual.xgen.genconf.constants;

public enum GenConfEnum {
	
	GenConf("GenConf", 0),
	NeedGens("NeedGens", 1),
	NeedGen("NeedGen", 0),
	Params("Params", 0),
	Param("Param", 0),
	Themes("Themes", 0),
	Theme("Theme", 0),
	Constants("Constants", 0),
	Constant("Constant", 0),
	id("id", 0),
	provider("provider", 0),
	themeId("themeId", 0);
	
	 // 成员变量  
    private String name;  
	private int index;  
    // 构造方法  
    private GenConfEnum(String name, int index) {  
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
