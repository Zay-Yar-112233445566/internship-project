package com.java.beans;

import java.util.Objects;

public class Route {
	private int routeId,fare;
    public String getDesiredDate() {
		return desiredDate;
	}
	public void setDesiredDate(String desiredDate) {
		this.desiredDate = desiredDate;
	}
	private String timeRequired,departurePoint,destinationPoint,desiredDate;
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getTimeRequired() {
		return timeRequired;
	}
	public void setTimeRequired(String timeRequired) {
		this.timeRequired = timeRequired;
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
}