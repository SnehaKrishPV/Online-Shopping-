package com.hibernateSpringRestSQL.dao;

import java.util.List;

import com.hibernateSpringRestSQL.entity.Advertisement;
import com.hibernateSpringRestSQL.entity.Categories;
import com.hibernateSpringRestSQL.entity.User;

public interface UserDAO {
	public User createUser(User user);
	public Categories createCategory(Categories categories);
	/*public String loginUser(User user);
	
	public String logout(String authToken);
*/
	public List<Categories> getCategories();
	/*
	public List<ActionsCollection> getActions(String authToken);

	public Advertisement postAd(Advertisement ad, String authToken);*/
}
