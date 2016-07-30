package com.zeeshan.hirearide.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeeshan.hirearide.beans.TripInfoBean;
import com.zeeshan.hirearide.dao.TripDAO;
import com.zeeshan.hirearide.domain.Car;
import com.zeeshan.hirearide.domain.Trip;
import com.zeeshan.hirearide.domain.User;
import com.zeeshan.hirearide.utils.HireARideUtil;

/**
 *<h1>TripInfoServiceImpl</h1>
 * provides service layer functionality mainly related to Booking Information 
 * implements TripInfoService interface
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category Service class
 * @since July 2016
 *
 */
@Service("tripInfoService")
@Transactional
public class TripInfoServiceImpl implements TripInfoService {

	@Autowired
	private TripDAO tripdao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CarService carService ;
	
	public void saveTrip(Trip tripinfo) {
		tripdao.saveTrip(tripinfo);

	}

	
	public List<Trip> findAllTripInfos() {
		// will be implemented propely in future
		return null;
	}

	
	public Trip findByUser(Integer userId) {
		// will be implemented propely in future
		return null;
	}

	
	public void deleteTripInfoByUser(Integer userId) {
		// will be implemented propely in future

	}

	
	public void updateTripInfo(Trip tripinfo) {
		// will be implemented propely in future

	}
	
	/* (non-Javadoc)
	 * @see com.zeeshan.hirearide.service.TripInfoService#prepareAndSaveTripInfo(com.zeeshan.hirearide.beans.TripInfoBean)
	 */
	public TripInfoBean prepareAndSaveTripInfo(TripInfoBean tripInfoBean){
		
	
		if(tripInfoBean.getEmail()==null || tripInfoBean.getEmail().isEmpty()){
			System.out.println("email is empty");
			return null;
		}
		if(tripInfoBean.getUsername()==null || tripInfoBean.getUsername().isEmpty())
		{
			System.out.println("username not found");
			return null;
		}
		if(tripInfoBean.getCar_id() < 1)
		{
			System.out.println("car not found");
			return null;
		}
		if(tripInfoBean.getPickupDatetime()==null || tripInfoBean.getDropDatetime() == null)
		{
			System.out.println("either pickup date or dropdate is null");
			return null;
		}
		if(tripInfoBean.getDropDatetime().before(tripInfoBean.getPickupDatetime()))
		{
			System.out.println("drop date time can not be before pickup datetime");
			return null;
		}
		
		Car   car = carService.findById(tripInfoBean.getCar_id());
		User user = userService.findByEmail(tripInfoBean.getEmail());
		if(user==null)
		{
			user = new User();
			user.setEmail(tripInfoBean.getEmail());
			user.setUsername(tripInfoBean.getUsername());
			user.setStatus("active");
		}
		userService.saveUser(user);
		Trip tripinfo = new Trip();
		tripinfo.setCar(car);
		tripinfo.setUser(user);
		tripinfo.setPickupPlace(tripInfoBean.getPickupPlace());
		tripinfo.setPickupDatetime(tripInfoBean.getPickupDatetime());
		tripinfo.setDropPlace(tripInfoBean.getDropPlace());
		tripinfo.setDropDatetime(tripInfoBean.getDropDatetime());
		tripinfo.setStatus("open");
		tripinfo.setTotalCharge(calculateTotalCharge(tripInfoBean.getPickupDatetime(), tripInfoBean.getDropDatetime(), car.getTrip_charge_perday()));
		
		saveTrip(tripinfo);
		tripInfoBean.setTotalCharge(tripinfo.getTotalCharge());
		return tripInfoBean;
		
	}

	/**
	 * calculates the difference in days between two dates 
	 * and returns the total rental charge for the calculated no of days
	 * it calculates the difference by subtracting the dates in long.
	 * thus calculates 24 hours as a day 
	 * 
	 * 
	 * @param pudt         - pickupDateTime (First Date)
	 * @param ddt		   - dropDateTime (Second Date)
	 * @param chargePerDay - trip_charge_perday from TripInfoBean object. Charge of selected car for a single day rent.
	 * @return Double      - total rental charge for calculated days
	 */
	Double calculateTotalCharge(Date pudt, Date ddt, BigDecimal chargePerDay ){
		HireARideUtil util = new HireARideUtil();
		long days = util.getDifferenceDays(pudt, ddt);
		return (days+1) * chargePerDay.doubleValue();
	}
	
	
}
