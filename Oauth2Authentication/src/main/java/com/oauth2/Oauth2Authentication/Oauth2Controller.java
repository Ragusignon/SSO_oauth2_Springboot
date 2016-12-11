package com.oauth2.Oauth2Authentication;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;

@RestController
public class Oauth2Controller {
	
	  @RequestMapping("/resource")
	  public Map<String,Object> home() {
		  System.out.println("Resource Method");
	    Map<String,Object> model = new HashMap<String,Object>();
	    model.put("id", UUID.randomUUID().toString());
	    model.put("content", "Hello World");
	    return model;
	  }

	  
	@RequestMapping("/welcome")
	public String greeting(){
		System.out.println("Welcome to Ragu Oauth2 Authentication");
		return "Welcome to Ragu Oauth2 Authentication";
	}
	@RequestMapping("/")
	public String home1() {
		System.out.println("Hello World to Ragu");
		return "Hello World to Ragu";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody MultiValueMap<String, String> map) {
		System.out.println("OK, Welcome to Ragu");
		return "OK, Welcome to Ragu";
	}
}
