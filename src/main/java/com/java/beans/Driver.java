package com.java.beans;

import java.util.Objects;

public class Driver {
	private int driverId,busId,routeId,	fare,timeRequired,numberOfSeats;
	private String newPassword,confirmPassword;


    public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public int getTimeRequired() {
		return timeRequired;
	}
	public void setTimeRequired(int timeRequired) {
		this.timeRequired = timeRequired;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
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
	public String getBusTypeName() {
		return busTypeName;
	}
	public void setBusTypeName(String busTypeName) {
		this.busTypeName = busTypeName;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	

	private String driverName,driverAddress,driverPhone,driverEmail,driverPassword,desiredDate,departureDate,departureTime,	departurePoint,destinationPoint,busTypeName;
	public String getDepartureTime() {
		return departureTime;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDesiredDate() {
		return desiredDate;
	}
	public void setDesiredDate(String desiredDate) {
		this.desiredDate = desiredDate;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverAddress() {
		return driverAddress;
	}
	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}
	public String getDriverPhone() {
		return driverPhone;
	}
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
	public String getDriverEmail() {
		return driverEmail;
	}
	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}
	public String getDriverPassword() {
		return driverPassword;
	}
	public void setDriverPassword(String driverPassword) {
		this.driverPassword = driverPassword;
	}

}