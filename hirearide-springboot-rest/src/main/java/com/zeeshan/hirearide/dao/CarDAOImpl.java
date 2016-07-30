package com.zeeshan.hirearide.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zeeshan.hirearide.domain.Car;

/**
 * <h1>CarDAOTmpl</h1>
 * provides implementation for CarDAO interface methods and extends AbstractDAO. 
 * contains methods for DAO layer to Car model.
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category DAO class
 * @since July 2016
 *
 */
@Repository("carDao")
public class CarDAOImpl extends AbstractDao implements CarDAO{



	public void saveCar(Car car) {
		// will be implemented propely in future

	}

	@SuppressWarnings("unchecked")
	public List<Car> findAllAvailableCars() {
		List<Car> cars;
		List<Integer> bookedCarIds = (List<Integer>) getSession().createQuery("select t.car.id from Trip t ").list();
		if(bookedCarIds!=null && bookedCarIds.size()>0)
		{	
			Query qry = getSession().createQuery("from Car c where c.id not in :ids").setParameterList("ids", bookedCarIds);
			cars = (List<Car>) qry.list();
		}else
		{	
			Criteria cr = getSession().createCriteria(Car.class);
			cars = (List<Car>) cr.list();
		}

		return cars;
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

		return (Car) getSession().load(Car.class, id);
	}



}
