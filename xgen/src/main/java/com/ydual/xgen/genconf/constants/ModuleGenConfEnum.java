package com.ydual.xgen.genconf.constants;

public enum ModuleGenConfEnum {

	ModuleGenConf("ModuleGenConf", 0),
	NeedGenTypes("NeedGenTypes", 1),
	NeedGenType("NeedGenType", 2),
	id("id", 3),
	NeedGenOutType("NeedGenOutType", 4),
	ExtendConfs("ExtendConfs", 5),
	ExtendConf("ExtendConf", 6),
	isSingle("isSingle", 7);
	
	// 成员变量  
    private String name;  
	private int index;  
    // 构造方法  
    private ModuleGenConfEnum(String name, int index) {  
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
