package com.java.beans;

import java.util.Objects;

public class InUse {
	private int inUseId;
	private String departureDate,departureTime,desiredDate;
	
	
	private int busId,busTypeId,numberOfSeats;
	private String busTypeName;
	
	
	private int driverId;
	private String driverName,driverPhone;
	
	
	
	private int routeId,fare;
	private  String departurePoint,destinationPoint,timeRequired;
	

	public int getBusTypeId() {
		return busTypeId;
	}
	public String getTimeRequired() {
		return timeRequired;
	}
	public void setTimeRequired(String timeRequired) {
		this.timeRequired = timeRequired;
	}
	public void setBusTypeId(int busTypeId) {
		this.busTypeId = busTypeId;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String getBusTypeName() {
		return busTypeName;
	}
	public void setBusTypeName(String busTypeName) {
		this.busTypeName = busTypeName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPhone() {
		return driverPhone;
	}
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getDeparturePoint() {
		return departurePoint;
	}
	public void setDeparturePoint(String departurePoint) {
		this.departurePoint = departurePoint;
	}
	public String getDestinationPoint() {
		return destinationPoint;
	}
	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}
	public int getInUseId() {
		return inUseId;
	}
	public String getDesiredDate() {
		return desiredDate;
	}
	public void setDesiredDate(String desiredDate) {
		this.desiredDate = desiredDate;
	}
	public void setInUseId(int inUseId) {
		this.inUseId = inUseId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

}