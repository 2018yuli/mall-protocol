package com.ydual.xgen.util.readxml;

public class ParseModel {
	private String eleName;
	private boolean propertyValue;
	private boolean end;
	private boolean singleValue;
	private String condition;

	public ParseModel() {
	}

	public String getEleName() {
		return eleName;
	}

	public void setEleName(String eleName) {
		this.eleName = eleName;
	}

	public boolean isPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(boolean propertyValue) {
		this.propertyValue = propertyValue;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public boolean isSingleValue() {
		return singleValue;
	}

	public void setSingleValue(boolean singleValue) {
		this.singleValue = singleValue;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String toString() {
		return (new StringBuilder("ParseModel [eleName=")).append(eleName).append(", propertyValue=")
				.append(propertyValue).append(", end=").append(end).append(", singleValue=").append(singleValue)
				.append(", condition=").append(condition).append("]").toString();
	}

}
