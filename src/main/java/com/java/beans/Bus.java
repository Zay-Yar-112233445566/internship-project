package com.java.beans;

import java.util.Objects;

public class Bus  {
	private int busId,busTypeId,count;
    private String busTypeName,desiredDate;
	public String getBusTypeName() {
		return busTypeName;
	}

	public String getDesiredDate() {
		return desiredDate;
	}

	public void setDesiredDate(String desiredDate) {
		this.desiredDate = desiredDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setBusTypeName(String busTypeName) {
		this.busTypeName = busTypeName;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getBusTypeId() {
		return busTypeId;
	}

	public void setBusTypeId(int busTypeId) {
		this.busTypeId = busTypeId;
	}

	
}