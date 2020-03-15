package com.cabbuddies.usermanagement.rest.controllers.profile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabbuddieslib.aop.helper.annotation.JWTValidate;
import com.cabbuddieslib.data.auth.JWT;
import com.cabbuddieslib.data.user.User;
import com.cabbuddieslib.managers.user.UserManager;
import com.cabbuddieslib.utils.Serialize;

@RestController
@DependsOn({"userManager"})
public class GetUserProfile {
	
	@Autowired
	UserManager userManager;
	
	@JWTValidate
	@RequestMapping(value="/me",method=RequestMethod.GET)
	public User validateJWT(HttpServletRequest hsr,JWT jwt) {
		if(jwt==null)
			return null;
		System.out.println(hsr.getHeader("authorization"));
		System.out.println(Serialize.toString(jwt));
		return userManager.getUser(jwt.getUserId());
	}
	
}
