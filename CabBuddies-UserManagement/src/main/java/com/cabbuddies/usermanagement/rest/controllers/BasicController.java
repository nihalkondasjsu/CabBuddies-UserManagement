package com.cabbuddies.usermanagement.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbuddieslib.aop.helper.annotation.Debug;
import com.cabbuddieslib.data.auth.JWT;
import com.cabbuddieslib.data.user.User;
import com.cabbuddieslib.managers.auth.JWTManager;
import com.cabbuddieslib.managers.user.UserManager;
import com.cabbuddieslib.utils.LibraryVersion;

import net.minidev.json.JSONObject;

@RestController
@DependsOn({"userManager","JWTManager"})
public class BasicController {

	@Autowired
	UserManager userManager;
	
	@Autowired
	JWTManager jwtManager;

	@RequestMapping(value="/happy",method=RequestMethod.GET)
	@ResponseBody
	@Debug
	public JSONObject index() {
		JSONObject json = new JSONObject();
		json.put("Happy", "Nihal");
		return json;
	}
	
	
	@RequestMapping(value="/libver",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject error() {
		JSONObject json = new JSONObject();
		json.put("libver", LibraryVersion.VERSION);
		return json;
	}
	

	@RequestMapping(value="/decodeJWT",method=RequestMethod.POST)
	@ResponseBody
	public JWT decodeJWT(@RequestBody String request) {
		return jwtManager.validateJWT(jwtManager.parseJWT(request));
	}
	

	@RequestMapping(value="/decodeJWT2User",method=RequestMethod.POST)
	@ResponseBody
	public User decodeJWT2User(@RequestBody String request) {
		return userManager.getUser(jwtManager.validateJWT(jwtManager.parseJWT(request)).getUserId());
	}
	
}
