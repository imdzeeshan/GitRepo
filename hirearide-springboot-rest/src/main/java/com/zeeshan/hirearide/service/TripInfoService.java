package com.zeeshan.hirearide.service;

import java.util.List;

import com.zeeshan.hirearide.beans.TripInfoBean;
import com.zeeshan.hirearide.domain.Trip;

public interface TripInfoService {
	
	void saveTrip(Trip tripinfo);

	List<Trip> findAllTripInfos();

	Trip findByUser(Integer userId);

	void deleteTripInfoByUser(Integer userId); 

	void updateTripInfo(Trip tripinfo);
	
	TripInfoBean prepareAndSaveTripInfo(TripInfoBean tripInfoBean); 
	
}
