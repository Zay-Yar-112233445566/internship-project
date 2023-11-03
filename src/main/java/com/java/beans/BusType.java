package com.java.beans;

import java.util.Objects;

public class BusType {
	private String busTypeName;
	private int numberOfSeats,busTypeId;

	public int getBusTypeId() {
		return busTypeId;
	}
	public void setBusTypeId(int busTypeId) {
		this.busTypeId = busTypeId;
	}
	
	public String getBusTypeName() {
		return busTypeName;
	}
	public void setBusTypeName(String busTypeName) {
		this.busTypeName = busTypeName;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}


    
}