package com.le.viet.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rs")
public class TemplateController {
	
	@RequestMapping(value = "/getTimeNow", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTimeNow(){
		Date now = new Date();
		return now.getTime();
	}
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping(){
		return "pong";
	}
}
