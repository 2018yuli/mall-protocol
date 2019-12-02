package com.ydual.xgen.util.readxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Context {

	private Document document;
	private List preEles;
	private static Map mapCtx = new HashMap();

	private Context(Document document) {
		this.document = null;
		preEles = new ArrayList();
		this.document = document;
	}

	public static Context getInstance(String filePathName) throws Exception {
		Context c = (Context) mapCtx.get(filePathName);
		if (c == null) {
			Document document = XmlUtil.getDocument(filePathName);
			c = new Context(document);
			mapCtx.put(filePathName, c);
		}
		c.init();
		return c;
	}

	public void init() {
		preEles = new ArrayList();
	}

	public List getPreEles() {
		return preEles;
	}

	public void setPreEles(List preEles) {
		this.preEles = preEles;
	}

	public Document getDocument() {
		return document;
	}

	public List getNowEles(Element pEle, String eleName) {
		List nowEles = new ArrayList();
		NodeList tempList = pEle.getChildNodes();
		for (int i = 0; i < tempList.getLength(); i++)
			if (tempList.item(i) instanceof Element) {
				Element ele = (Element) tempList.item(i);
				if (ele.getTagName().equals(eleName))
					nowEles.add(ele);
			}

		return nowEles;
	}

	public boolean judgeCondition(Element ele, String condition) {
		if (condition == null || condition.trim().length() == 0)
			return true;
		String ss[] = condition.split("=");
		return ss[1] != null && ss[1].equals(ele.getAttribute(ss[0]));
	}

}
