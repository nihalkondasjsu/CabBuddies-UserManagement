package com.cabbuddies.usermanagement.rest.controllers.registration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbuddieslib.managers.auth.JWTManager;
import com.cabbuddieslib.managers.user.UserManager;
import com.cabbuddieslib.data.user.User;
import com.cabbuddieslib.data.user.UserDetails;
import com.cabbuddieslib.utils.RemoteIP;

import net.minidev.json.JSONObject;

@RestController
@DependsOn({"userManager","JWTManager"})
public class InAppRegistrationController {

	@Autowired
	UserManager userManager;
		
	@Autowired
	JWTManager jwtManager;
	
	@RequestMapping(value="/register/inapp",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject register(HttpServletRequest hsr,UserDetails userDetails) {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("scs", false);
		
		try {
			User user = userManager.registerUser(userDetails);
			String ip = RemoteIP.getIP(hsr);
			jsonObject.put("jwt",jwtManager.clientVersion(jwtManager.createJWT(ip, user.getId())));
			jsonObject.put("scs", true);
			return jsonObject;
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("msg",e.getMessage());
			return jsonObject;
		}
		
	}
	
}
