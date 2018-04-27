package com.hibernateSpringRestSQL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hibernateSpringRestSQL.dao.UserDAO;
import com.hibernateSpringRestSQL.entity.Advertisement;
import com.hibernateSpringRestSQL.entity.Categories;
import com.hibernateSpringRestSQL.entity.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	public User createUser(User user) {
		return userDao.createUser(user);
	}
	public Categories createCategory(Categories categories) {
		return userDao.createCategory(categories);
	}
	
	/*public String loginUser(User user) {
		return userDao.loginUser(user);
	}

	public String logout(String authToken){
		return userDao.logout(authToken);
	}*/
	public List<Categories> getCategories(){
		return userDao.getCategories();
	}
	/*
	public List<ActionsCollection> getActions(String authToken){
		return userDao.getActions(authToken);
	}
	public Advertisement postAd(Advertisement ad, String authToken){
		return userDao.postAd(ad, authToken);
	}*/
}
