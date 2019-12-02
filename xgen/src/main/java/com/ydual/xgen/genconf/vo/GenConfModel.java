package com.ydual.xgen.genconf.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class GenConfModel {

	private List needGens;
	private List themes;
	private Map mapConstants;

	public GenConfModel() {
		needGens = new ArrayList();
		themes = new ArrayList();
		mapConstants = new HashMap();
	}

	public List getNeedGens() {
		return needGens;
	}

	public void setNeedGens(List needGens) {
		this.needGens = needGens;
	}

	public List getThemes() {
		return themes;
	}

	public void setThemes(List themes) {
		this.themes = themes;
	}

	public Map getMapConstants() {
		return mapConstants;
	}

	public void setMapConstants(Map mapConstants) {
		this.mapConstants = mapConstants;
	}

	public ThemeModel getThemeById(String themeId) {
		for (Iterator iterator = themes.iterator(); iterator.hasNext();) {
			ThemeModel tm = (ThemeModel) iterator.next();
			if (tm.getId().equals(themeId))
				return tm;
		}

		return new ThemeModel();
	}

	public String toString() {
		return (new StringBuilder("GenConfModel [needGens=")).append(needGens).append(", themes=").append(themes)
				.append(", mapConstants=").append(mapConstants).append("]").toString();
	}

}
