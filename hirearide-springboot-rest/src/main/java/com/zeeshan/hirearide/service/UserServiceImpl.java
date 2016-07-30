package com.zeeshan.hirearide.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeeshan.hirearide.dao.UserDAO;
import com.zeeshan.hirearide.domain.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userdao;
	
	public void saveUser(User user) {
		
		userdao.saveUser(user);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteUserByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	public User findById(Integer id) {
	
		return userdao.findById(id);
	}

}
