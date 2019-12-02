package com.ydual.xgen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

public class ThemeModel {

	private String id;
	private String location;
	private Map mapGenTypes;
	private Map mapGenOutTypes;
	private Map mapProviders;

	public ThemeModel() {
		mapGenTypes = new HashMap();
		mapGenOutTypes = new HashMap();
		mapProviders = new HashMap();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Map getMapGenTypes() {
		return mapGenTypes;
	}

	public void setMapGenTypes(Map mapGenTypes) {
		this.mapGenTypes = mapGenTypes;
	}

	public Map getMapGenOutTypes() {
		return mapGenOutTypes;
	}

	public void setMapGenOutTypes(Map mapGenOutTypes) {
		this.mapGenOutTypes = mapGenOutTypes;
	}

	public Map getMapProviders() {
		return mapProviders;
	}

	public void setMapProviders(Map mapProviders) {
		this.mapProviders = mapProviders;
	}

	public String toString() {
		return (new StringBuilder("ThemeModel [id=")).append(id).append(", location=").append(location)
				.append(", mapGenTypes=").append(mapGenTypes).append(", mapGenOutTypes=").append(mapGenOutTypes)
				.append(", mapProviders=").append(mapProviders).append("]").toString();
	}

}
