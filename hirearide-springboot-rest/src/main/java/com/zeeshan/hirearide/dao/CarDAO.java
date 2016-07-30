package com.zeeshan.hirearide.dao;

import java.util.List;

import com.zeeshan.hirearide.domain.Car;

/**
 *<h1>Interface CarDAO</h1>
 * provides basic DAO methods for Car Model class
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category DAO interface
 * @since July 2016
 *
 */
public interface CarDAO {

	/**
	 * persists Car POJO
	 *	
	 * @param car
	 */
	void saveCar(Car car);


	/**
	 * provides the list of all those cars which are not yet booked.
	 *  
	 * @return List of Cars (List<Car>)
	 */
	List<Car> findAllAvailableCars();

	/**
	 * meant for returning a Car of particular model 
	 * <i>not yet implemented</i>
	 * 
	 * @param model of car
	 * @return Car
	 */
	Car findByModel(String model);

	/**
	 * meant for deleting Car Object based on particular model
	 * <i>not yet implemented</i>
	 * 
	 * @param model of car
	 */
	void deleteCarByModel(String model); 

	/**
	 * to update an existing Car details 
	 * <i>not yet implemented</i>
	 * 
	 * @param car- existing car object whose details are to be updated
	 */
	void updateCar(Car car);

	/**
	 * provides a unique car by searching the database for a car record of particular id.
	 * 
	 * @param id - row id of car in db
	 * @return Car object
	 */
	Car findById(Integer id);

}

