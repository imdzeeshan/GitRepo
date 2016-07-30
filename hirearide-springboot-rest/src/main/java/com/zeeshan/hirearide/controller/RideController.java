package com.zeeshan.hirearide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zeeshan.hirearide.beans.TripInfoBean;
import com.zeeshan.hirearide.domain.Car;
import com.zeeshan.hirearide.domain.Trip;
import com.zeeshan.hirearide.service.CarService;
import com.zeeshan.hirearide.service.TripInfoService;

/**
 * <h1>RideController</h1>
 * The RideController class serves as the RestController for the hirearide-springboot-web
 * application. Currently it contains two methods: one for fetching all available cars(cars which are not yet booked)
 * and second method does the task of booking cars.
 * 
 * 
 * @author Muhammad Zeeshan
 * @version 1.0.0
 * @category RestController
 * @since July 2016
 * 
 */
@RestController
public class RideController {
	
	/**
	 * carService -- CarService object 
	 * tripInfoService -- TripInfoService object
	 * 
	 */
	@Autowired
	CarService carService ;
	
	@Autowired
	TripInfoService tripInfoService;
	
	
	/**
	 * <b>fetchCars</b> method 
	 * Attached with the RequestMapping to "/getCars".
	 * Accepts GET request
	 * Calls CarService's findAllAvailableCars() method which returns the list of Cars.
	 * 
	 * @return List of Car objects(List<Car>) 
	 */
	@RequestMapping("/getCars")
	public List<Car> fetchCars(){
		System.out.println("processing findAllCArs");
		
		return  carService.findAllAvailableCars();
		
	}
	
	
	/**
	 * <b>doBooking</b> method 
	 * Attached with the RequestMapping to "/bookRide".
	 * Accepts POST request with expected TripInfoBean Object in RequestBody.
	 * Invokes prepareAndSaveTripInfo(TripInfoBean tripInfoBean) method of TripInfoService Class.
	 * result of this method i.e. TripInfoBean Object is returned.
	 * 
	 * 
	 * @param tripInfoBean
	 * 
	 * @return TripInfoBean Object 
	 */
	@RequestMapping(value = "/bookRide", method = RequestMethod.POST)
	public TripInfoBean doBooking(@RequestBody TripInfoBean tripInfoBean){
		System.out.println("processing booking..");
	
		return tripInfoService.prepareAndSaveTripInfo(tripInfoBean) ;
		
	}
}
