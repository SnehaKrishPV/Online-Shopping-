package com.hibernateSpringRestSQL.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernateSpringRestSQL.entity.User;
import com.hibernateSpringRestSQL.entity.Advertisement;
import com.hibernateSpringRestSQL.entity.Categories;
import com.hibernateSpringRestSQL.service.UserService;

@RestController
@RequestMapping("/xornet")
public class UserController {
	
	@Autowired
	UserService userService;
	
		
	// POST
	/*@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User CreateUser(@RequestBody User user) {
		System.out.println("User: " + user);
		return user;
	}*/

	// GET
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("tom", "cat","tom123", "tom123", "tom@gmail.com", 1211));
		users.add(new User("ivan","cat", "ivan123", "ivan123","ivan@gmail.com", 122211));
		return users;
	}
	
	@RequestMapping(value = "/hello/{city}", method = RequestMethod.GET)
	public String sayHello(@RequestParam(name = "name", defaultValue = "Ivan") String uname,
			@PathVariable(value = "city") String myCity, @RequestHeader(value = "auth-token") String authToken) {
		System.out.println("myCity = " + myCity);
		System.out.println("authToken = " + authToken);
		return "Hello " + uname;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(@RequestParam(name = "name", defaultValue = "Ivan") String userName) {
		return "Hello" + userName;

	}

	@RequestMapping(value = "/matrix/{userDetails}", method = RequestMethod.GET) // done
	public Map<String, String> printMatrix(@MatrixVariable(pathVar = "userDetails", name = "name") String name,
			@MatrixVariable(pathVar = "userDetails", name = "city") String city) {
		System.out.println("Name: " + name);
		System.out.println("City: " + city);

		Map<String, String> matrixData = new HashMap<String, String>();
		matrixData.put(name, city);
		return matrixData;
	}
	//http://localhost:9999/xornet/matrix/id=15;name=ekta;city=pune

	//Registration
	@RequestMapping(value="/register", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User createUser(@RequestBody User user) {
		System.out.println("user = " + user);
		return userService.createUser(user);
	}
	
	//Login
	/*@RequestMapping(value="/login", method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginUser(@RequestBody User user){
		System.out.println("user= " +user);
		String auth_token = userService.loginUser(user);
		JSONObject jsonString = new JSONObject();
		jsonString.put("auth-token", auth_token);
		return jsonString.toString();
	}
	
	//Logout
	/*@RequestMapping(value="/logout", method=RequestMethod.DELETE)
	public String logout (@RequestHeader(value = "auth-token") String authToken){
		return userService.logout(authToken);
	} 
	*/
	//categories
	@RequestMapping(value="/categories", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Categories> getCategories(){
		List<Categories> categories = userService.getCategories();
		return categories;
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Categories createCategory(@RequestBody Categories categories) {
		System.out.println("categories = " + categories);
		return userService.createCategory(categories);
	}
	/*
	//actions
	@RequestMapping(value="/actions", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ActionsCollection> getActions(@RequestHeader(value = "auth-token") String authToken){
		List<ActionsCollection> actions = userService.getActions(authToken);
		return actions;
	}
	
	//Post Ad
	@RequestMapping(value="/postAd", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Advertisement postAd(@RequestBody Advertisement ad, @RequestHeader(value = "auth-token") String authToken) {
		System.out.println("Advertisement = " + ad);
		return userService.postAd(ad, authToken);	
	}
	*/
}
