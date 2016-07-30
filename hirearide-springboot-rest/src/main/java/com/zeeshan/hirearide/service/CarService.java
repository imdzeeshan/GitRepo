package com.zeeshan.hirearide.service;

import java.util.List;

import com.zeeshan.hirearide.domain.Car;

/**
 *<h1>Interface CarService</h1>
 * provides service layer functionality mainly related to Cars 
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category Service interface
 * @since July 2016
 *
 */
public interface CarService {

	/**
	 * persists Car Object
	 * <br><i> not yet implemented </i>
	 * 
	 * @param car -- Car Object
	 */
	void saveCar(Car car);
	
	
	/** 
	 * <ul><li>searches for all available cars and returns in a list 
	 * <li>uses CarDAO
	 * </ul>
	 * @return List<Car> -- list of cars
	 */
	List<Car> findAllAvailableCars();
	
	
	/**
	 * meant for returning a Car of particular model using CarDAO
	 * <br><i>not yet implemented</i>
	 * 
	 * @param model -- model of car
	 * @return Car  -- Object of Car
	 */
	Car findByModel(String model);
	
	
	/**
	 * meant for deleting Car Object based on particular model using CarDAO
	 * <br><i>not yet implemented</i>
	 * 
	 * @param model -- model of car
	 */
	void deleteCarByModel(String model); 
		
	
	/**
	 * to update an existing Car details 
	 * <br>uses CarDAO
	 * <i>not yet implemented</i>
	 * 
	 * @param car -- existing car object whose details are to be updated
	 */
	void updateCar(Car car);
	
	
	/**
	 * provides a unique car by searching the database for a car record of particular id.
	 * 
	 * @param id -- car.id of TripInfoBean from controller
	 * @return Car object
	 */
	 Car findById(Integer id);
}
