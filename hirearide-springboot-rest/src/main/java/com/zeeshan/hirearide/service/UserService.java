package com.zeeshan.hirearide.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.zeeshan.hirearide.domain.User;

/**
 *<h1>Interface UserService</h1>
 * provides service layer functionality mainly related to User Information
 *  
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category Service interface
 * @since July 2016
 *
 */
public interface UserService {

	/**
	 * persists User POJO
	 *	
	 * @param user - a User POJO
	 */
void saveUser(User user);
	

/**
 * provides the list of all users.
 *  
 * @return List of Users (List<User>)
 */
	List<User> findAllUsers();
	
	
	/**
	 *  returns a User against an email 
	 *
	 * 
	 * @param email 
	 * @return User
	 */
	User findByEmail(String email);
	
	
	/**
	 * meant for deleting User Object based on particular email
	 * <br><i>not yet implemented</i>
	 * 
	 * @param email
	 */
	void deleteUserByEmail(String email); 
		
	
	/**
	 * to update an existing User's details 
	 * <br><i>not yet implemented</i>
	 * 
	 * @param user
	 */
	void updateUser(User user);
	
	
	/**
	 *  provides a unique user by searching the database for a user record of particular id.
	 *  
	 * @param id   
	 * @return User
	 */
	 User findById(Integer id);
	
}
