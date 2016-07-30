package com.zeeshan.hirearide.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *<h1>Trip</h1>
 * It is the domain or model class. also referred as POJO Class
 * Contains the mapping annotaion for ORM purpose. Maps Trip object to tbl_trip_info in db
 *  
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category POJO/model class
 * @since July 2016
 *
 */
@Entity
@Table(name="tbl_trip_info")
@JsonIgnoreProperties({"car","user"})
public class Trip implements java.io.Serializable{

	/**
	 *  id               -- uniquley identifies an object/record
	 *  car				 -- A Car POJO (many to one column for tbl_car)
	 *  user			 -- A User POJO (many to one column for tbl_user)
	 *  pickupPlace		 -- pick up place where user wants a car to start the journey
	 *  pickupDatetime   -- Date and Time when user wants to start the journey
	 *  dropPlace 		 -- drop place where user wants to end his journey
	 *  dropDatetime	 -- Date and Time Expected to end the journey
	 *  totalCharge		 -- Total charge in USD applicable to be paid by the user
	 *  daysOnTrip		 -- No of days a car is on rent for a trip. calculated as difference between pickupDatetime and dropDatetime
	 *  status           -- status field currently for future use
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@ManyToOne(optional = false)
	@JoinColumn(name="car")
	private Car car;
	

	@ManyToOne(optional = false)
	@JoinColumn(name="user")
	private User user;
	
	@Column(name = "pickup_place")
	private String pickupPlace;
	
	@Column(name = "pickup_datetime")
	private Date pickupDatetime;

	@Column(name = "drop_place")
	private String dropPlace;
	
	@Column(name = "drop_datetime")
	private Date dropDatetime;
	
	@Column(name = "total_charge")
	private Double totalCharge;
	
	@Column(name = "days_on_trip")
	private BigDecimal daysOnTrip;
	
	@Column(name = "status", nullable = false)
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public BigDecimal getDaysOnTrip() {
		return daysOnTrip;
	}

	public void setDaysOnTrip(BigDecimal daysOnTrip) {
		this.daysOnTrip = daysOnTrip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	
	

}
