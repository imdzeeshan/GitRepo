package com.zeeshan.hirearide.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.zeeshan.hirearide.domain.User;

public interface UserService {

void saveUser(User user);
	
	List<User> findAllUsers();
	
	User findByEmail(String email);
	
	void deleteUserByEmail(String email); 
		
	void updateUser(User user);
	
	 User findById(Integer id);
	
}
