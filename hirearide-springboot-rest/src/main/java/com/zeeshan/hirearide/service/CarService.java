package com.zeeshan.hirearide.service;

import java.util.List;

import com.zeeshan.hirearide.domain.Car;

/**
 *<h1>Interface CarService</h1>
 * implements service layer mainly related to Cars 
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category Service class
 * @since July 2016
 *
 */
public interface CarService {

	/**
	 * persists Car Object
	 *	
	 * @param car - Car Object
	 */
	void saveCar(Car car);
	
	List<Car> findAllAvailableCars();
	
	Car findByModel(String model);
	
	void deleteCarByModel(String model); 
		
	void updateCar(Car car);
	
	 Car findById(Integer id);
}
