package com.cabbuddies.usermanagement.rest.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.RestController;

import com.cabbuddieslib.managers.auth.JWTManager;

@RestController
@DependsOn({"JWTManager"})
public class JWTValidatorAuth {

	@Autowired
	JWTManager jwtManager;
	
	
	
}
