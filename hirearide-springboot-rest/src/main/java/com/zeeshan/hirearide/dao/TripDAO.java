package com.zeeshan.hirearide.dao;

import java.util.List;

import com.zeeshan.hirearide.domain.Trip;

/**
 *<h1>Interface TripDAO</h1>
 * provides basic DAO methods for Trip Model class. DAO access layer
 * for maintaining Trip Information i.e. booking information of a user.
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category DAO interface
 * @since July 2016
 *
 */
public interface TripDAO {


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
	 * @return List<Trip>-- List of Trip Information 
	 */
	List<Trip> findAllTripInfos();


	/**
	 * meant for returning Trip Object for a user.
	 * <ul><li>note- user means here particular record from db table user
	 * <li>in future this method will be changed to return a list of trip infos
	 * </ul>
	 * 
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
	 * @param tripinfo -- existing Trip object whose details are to be updated
	 */
	void updateTripInfo(Trip tripinfo);

}
