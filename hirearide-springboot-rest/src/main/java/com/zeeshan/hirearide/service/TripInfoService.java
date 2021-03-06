package com.zeeshan.hirearide.service;

import java.util.List;

import com.zeeshan.hirearide.beans.TripInfoBean;
import com.zeeshan.hirearide.domain.Trip;

/**
 *<h1>Interface TripInfoService</h1>
 * provides service layer functionality mainly related to Trip Information or Booking Information
 *  
 * 
 * 
 * @author Muhammad Zeeshan
 * @version 1.0.0
 * @category Service interface
 * @since July 2016
 *
 */
public interface TripInfoService {
	
	/**
	 * persists Trip POJO
	 * 
	 * @param tripinfo -- a Trip object to be saved
	 */
	void saveTrip(Trip tripinfo);

	
	/**
	 * provides the list of all booking information.
	 * <br><i>not yet implemented</i>
	 * 
	 * @return List of Trip Information (List<Trip>)
	 */
	List<Trip> findAllTripInfos();

	
	/**
	 * meant for returning Trip Object for a user.
	 * <ul><li>note- user means here particular record from db table user
	 * <li>in future this method will be changed to return a list of trip infos
	 * </ul>
	 * @param userId
	 * @return Trip -- Trip Information for a particular user id
	 */
	Trip findByUser(Integer userId);

	
	/**
	 * meant for deleting Trip Object based on particular userId
	 * <br><i>not yet implemented</i>
	 * 
	 * @param userId
	 */
	void deleteTripInfoByUser(Integer userId); 

	
	/**
	 * to update an existing TripInformation details 
	 * <br><i>not yet implemented</i>
	 * 
	 * @param tripinfo- existing Trip object whose details are to be updated
	 */
	void updateTripInfo(Trip tripinfo);
	
	/**
	 * <ul><li>Saves the Trip Information and user details after calculating total rental charges
	 * <li>returns the updated tripInfoBean Object.
	 * </ul>
	 * @param tripInfoBean - TripInfoBean Object from controller which is received alongwith post request at "/bookRide". 
	 * @return updated TripInfoBean Object after saving to db
	 */
	TripInfoBean prepareAndSaveTripInfo(TripInfoBean tripInfoBean); 
	
}
