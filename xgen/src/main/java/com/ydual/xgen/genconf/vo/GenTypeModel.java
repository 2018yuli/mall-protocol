package com.ydual.xgen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

public class GenTypeModel {

	private String id;
	private String genTypeClass;
	private Map mapParams;

	public GenTypeModel() {
		mapParams = new HashMap();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenTypeClass() {
		return genTypeClass;
	}

	public void setGenTypeClass(String genTypeClass) {
		this.genTypeClass = genTypeClass;
	}

	public Map getMapParams() {
		return mapParams;
	}

	public void setMapParams(Map mapParams) {
		this.mapParams = mapParams;
	}

	public String toString() {
		return (new StringBuilder("GenTypeModel [id=")).append(id).append(", genTypeClass=").append(genTypeClass)
				.append(", mapParams=").append(mapParams).append("]").toString();
	}

}
