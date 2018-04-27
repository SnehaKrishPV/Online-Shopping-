package com.hibernateSpringRestSQL.dao;

import java.util.List;

import org.hibernate.Query;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;


import com.hibernateSpringRestSQL.entity.Advertisement;
import com.hibernateSpringRestSQL.entity.Categories;
import com.hibernateSpringRestSQL.entity.User;

public class UserSQLDAOImpl extends HibernateDaoSupport implements UserDAO {


	@Transactional
	public User createUser(User user) {
		getHibernateTemplate().save(user);
		return user;
	}
	@Transactional
	public Categories createCategory(Categories categories) {
		getHibernateTemplate().save(categories);
		return categories;
	}
	/*
	public String loginUser(User user) {
		
		LoginCollection session = null;
		UserCollection users = userRepository.getUsers(user.getUserName(), user.getPassword());
		
		if(users==null) {
			System.out.println("Login unsuccessful!");
			
		}
		else{
			System.out.println("User :" + users.toString());
			session = new LoginCollection();
			session.createSession(user);
			loginRepository.save(session);
			return session.getId();
		}
		return null;
	
		
	}
	/*
	public String logout(String authToken){
		List<LoginCollection> log  = loginRepository.getToken(authToken);
		if(log.isEmpty()){
			return "Not Logged In";
		}
		else{
			loginRepository.delete(authToken);
			return "Logout Successful";
		}
		
	}*/
	
	public List<Categories> getCategories(){
		
		List<Categories> categories = (List<Categories>) getHibernateTemplate().find("from Categories"); // HQL
		return categories;
	}
	/*
	public List<ActionsCollection> getActions(String authToken){
		
		List<LoginCollection> log  = loginRepository.getToken(authToken);
		if(log.isEmpty()){
			System.out.println("Not Logged In");
			return null;
		}
		else{
			List<ActionsCollection> actions  = actionsRepository.findAll();
			return actions;
		}
	}
	public Advertisement postAd(Advertisement ad, String authToken){
		List<LoginCollection> log  = loginRepository.getToken(authToken);
		if(log.isEmpty()){
			System.out.println("Not Logged In");
			return null;
		}
		else{
		AdvertisementCollection adCollection = new AdvertisementCollection();
		adCollection.setTitle(ad.getTitle());
		adCollection.setName(ad.getName());
		adCollection.setCategory(ad.getCategory());
		adCollection.setDescription(ad.getDescription());
		System.out.println("Inside DAO ");
		advertisementRepository.save(adCollection);
		return ad;
		}
	}*/

}
