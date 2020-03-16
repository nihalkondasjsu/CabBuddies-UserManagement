package com.cabbuddies.usermanagement.rest.controllers.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabbuddieslib.aop.helper.annotation.JWTValidate;
import com.cabbuddieslib.data.auth.JWT;
import com.cabbuddieslib.managers.auth.JWTManager;
import com.cabbuddieslib.utils.Serialize;

@RestController
@DependsOn({"JWTManager"})
public class JWTValidatorController {

	@Autowired
	JWTManager jwtManager;
	
	@JWTValidate
	@RequestMapping(value="/validateJWT",method=RequestMethod.POST)
	public JWT validateJWT(HttpServletRequest hsr,JWT jwt) {
		System.out.println(hsr.getHeader("authorization"));
		System.out.println(Serialize.toString(jwt));
		return jwt;
	}
	
}
