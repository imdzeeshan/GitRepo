package com.zeeshan.hirearide.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zeeshan.hirearide.domain.User;

/**
 * <h1>UserDAOTmpl</h1>
 * provides implementation for UserDAO interface methods and extends AbstractDAO. 
 * contains methods for DAO layer to User model.
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category DAO class
 * @since July 2016
 *
 */
@Repository("userDAO")
public class UserDAOImpl extends AbstractDao implements UserDAO{

	
	public void saveUser(User user) {
		persist(user);
		
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	
	public User findByEmail(String email) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		return (User) criteria.uniqueResult();
	}

	
	public void deleteUserByEmail(String email) {
		// will be implemented propely in future
		
	}


	public void updateUser(User user) {
		// will be implemented propely in future
		
	}

	public User findById(Integer id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		return (User) criteria.uniqueResult();
	}
}
