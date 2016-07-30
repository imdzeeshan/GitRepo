package com.zeeshan.hirearide.dao;

import java.util.List;

import com.zeeshan.hirearide.domain.User;


/**
 *<h1>Interface UserDAO</h1>
 * provides basic DAO methods for User Model class. DAO access layer
 * for maintaining User Information.
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category DAO interface
 * @since July 2016
 *
 */
public interface UserDAO {

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
	 *  meant for returning a User against an email 
	 *
	 * 
	 * @param email
	 * @return User
	 */
	User findByEmail(String email);


	/**
	 * meant for deleting User Object based on particular email
	 * <i>not yet implemented</i>
	 * 
	 * @param email
	 */
	void deleteUserByEmail(String email); 


	/**
	 * to update an existing User's details 
	 * <i>not yet implemented</i>
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
