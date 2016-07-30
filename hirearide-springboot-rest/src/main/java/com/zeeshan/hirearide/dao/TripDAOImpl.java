package com.zeeshan.hirearide.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zeeshan.hirearide.domain.Trip;

/**
 * <h1>TripDAOTmpl</h1>
 * provides implementation for TripDAO interface methods and extends AbstractDAO. 
 * contains methods for DAO layer to Trip model.
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category DAO class
 * @since July 2016
 *
 */
@Repository("tripDAO")
public class TripDAOImpl extends AbstractDao implements TripDAO{


	public void saveTrip(Trip tripinfo) {
		persist(tripinfo);

	}

	@SuppressWarnings("unchecked")
	public List<Trip> findAllTripInfos() {
		Criteria criteria = getSession().createCriteria(Trip.class);
		return (List<Trip>) criteria.list();
	}


	public Trip findByUser(Integer userId) {
		Criteria criteria = getSession().createCriteria(Trip.class);
		criteria.add(Restrictions.eq("user.id", userId));
		return (Trip) criteria.uniqueResult();
	}


	public void deleteTripInfoByUser(Integer userId) {
		// will be implemented propely in future

	}


	public void updateTripInfo(Trip tripinfo) {
		// will be implemented propely in future

	}




}
