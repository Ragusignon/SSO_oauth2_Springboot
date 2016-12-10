package com.oauth2.Oauth2Authentication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2Controller {
	
	@RequestMapping("/welcome")
	public String greeting(){
		return "Welcome to Ragu Oauth2 Authentication";
	}

}
