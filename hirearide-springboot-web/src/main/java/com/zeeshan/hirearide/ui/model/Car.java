package com.zeeshan.hirearide.ui.model;

import java.math.BigDecimal;

/**
 *<h1>Car</h1>
 * It is a Bean Class
 * holds the data for Car Object
 *  
 *  
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category Bean class
 * @since July 2016
 *
 */
public class Car {

	
	/**
	 *  id               -- uniquley identifies an object/record
	 *  company          -- maker of car
	 *  model            -- model of a car 
	 *  seating_capacity -- seating capacity of a car
	 *  luggage_capacity -- luggage capacity of a car (no of travelling bags)
	 *  trip_charge_perday -- charge for renting a car for a day in USD 
	 *  status           -- status field currently for future use
	 */
	
	
	private int id;

	
	private String company;

	
	private String model;
	
	
	private BigDecimal seating_capacity;
	

	private BigDecimal luggage_capacity;
	

	private BigDecimal trip_charge_perday;
	
	
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getSeating_capacity() {
		return seating_capacity;
	}

	public void setSeating_capacity(BigDecimal seating_capacity) {
		this.seating_capacity = seating_capacity;
	}

	public BigDecimal getLuggage_capacity() {
		return luggage_capacity;
	}

	public void setLuggage_capacity(BigDecimal luggage_capacity) {
		this.luggage_capacity = luggage_capacity;
	}

	public BigDecimal getTrip_charge_perday() {
		return trip_charge_perday;
	}

	public void setTrip_charge_perday(BigDecimal trip_charge_perday) {
		this.trip_charge_perday = trip_charge_perday;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Car))
			return false;
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}
	
	
}
