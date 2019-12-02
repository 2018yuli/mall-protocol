package com.ydual.xgen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

public class NeedGenModel {
	private String id;
	private String provider;
	private String theme;
	private Map mapParams;

	public NeedGenModel() {
		mapParams = new HashMap();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Map getMapParams() {
		return mapParams;
	}

	public void setMapParams(Map mapParams) {
		this.mapParams = mapParams;
	}

	public String toString() {
		return (new StringBuilder("NeedGenModel [id=")).append(id).append(", provider=").append(provider)
				.append(", theme=").append(theme).append(", mapParams=").append(mapParams).append("]").toString();
	}

}
