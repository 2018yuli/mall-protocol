package com.ydual.xgen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

public class ModuleConfModel {

	private String moduleId;
	private String useTheme;
	private Map mapNeedGendTypes;
	private Map mapExtends;

	public ModuleConfModel() {
		moduleId = "";
		useTheme = "";
		mapNeedGendTypes = new HashMap();
		mapExtends = new HashMap();
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getUseTheme() {
		return useTheme;
	}

	public void setUseTheme(String useTheme) {
		this.useTheme = useTheme;
	}

	public Map getMapNeedGendTypes() {
		return mapNeedGendTypes;
	}

	public void setMapNeedGendTypes(Map mapNeedGendTypes) {
		this.mapNeedGendTypes = mapNeedGendTypes;
	}

	public Map getMapExtends() {
		return mapExtends;
	}

	public void setMapExtends(Map mapExtends) {
		this.mapExtends = mapExtends;
	}

	public String toString() {
		return (new StringBuilder("ModuleConfModel [moduleId=")).append(moduleId).append(", useTheme=").append(useTheme)
				.append(", mapNeedGendTypes=").append(mapNeedGendTypes).append(", mapExtends=").append(mapExtends)
				.append("]").toString();
	}

}
