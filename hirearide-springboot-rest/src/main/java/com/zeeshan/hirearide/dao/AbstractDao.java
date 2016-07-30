package com.zeeshan.hirearide.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h1>Abstract Class AbstractDAO</h1>
 * provides Hibernate session 
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category AbstractDAO class
 * @since July 2016
 *
 */
public abstract class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}
}
