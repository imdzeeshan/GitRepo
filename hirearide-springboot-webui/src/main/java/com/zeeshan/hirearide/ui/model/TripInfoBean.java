package com.zeeshan.hirearide.ui.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



public class TripInfoBean {


	private int id;

	private int car_id;
	
	private int user_id;
	
	@NotEmpty(message = "A Pick up Place is required!")
	private String pickupPlace;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date pickupDatetime;

	private String dropPlace;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date dropDatetime;
	
	private Double totalCharge;
	
	
	private String username;


	private String email;
	
	private Car car;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getPickupPlace() {
		return pickupPlace;
	}

	public void setPickupPlace(String pickupPlace) {
		this.pickupPlace = pickupPlace;
	}

	
	public String getDropPlace() {
		return dropPlace;
	}

	public void setDropPlace(String dropPlace) {
		this.dropPlace = dropPlace;
	}

	public Double getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(Double totalCharge) {
		this.totalCharge = totalCharge;
	}


	public Date getPickupDatetime() {
		return pickupDatetime;
	}

	public void setPickupDatetime(Date pickupDatetime) {
		this.pickupDatetime = pickupDatetime;
	}

	public Date getDropDatetime() {
		return dropDatetime;
	}

	public void setDropDatetime(Date dropDatetime) {
		this.dropDatetime = dropDatetime;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
