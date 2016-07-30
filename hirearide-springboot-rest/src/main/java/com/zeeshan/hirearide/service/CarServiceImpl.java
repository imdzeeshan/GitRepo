package com.zeeshan.hirearide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeeshan.hirearide.dao.CarDAO;
import com.zeeshan.hirearide.domain.Car;

/**
 *<h1>CarServiceImpl</h1>
 * provides service layer functionality mainly related to Cars 
 * implements CarService interface
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category Service class
 * @since July 2016
 *
 */
@Service("carService")
@Transactional
public class CarServiceImpl implements CarService{

	@Autowired
	private CarDAO cardao;
	
	
	public void saveCar(Car car) {
		// will be implemented propely in future
		
	}


	public List<Car> findAllAvailableCars() {
		
		return cardao.findAllAvailableCars();
	}


	public Car findByModel(String model) {
		// will be implemented propely in future
		return null;
	}

	
	public void deleteCarByModel(String model) {
		// will be implemented propely in future
		
	}

	
	public void updateCar(Car car) {
		// will be implemented propely in future
		
	}
	
	public Car findById(Integer id) {
		
		return cardao.findById(id);
	}

	

}
