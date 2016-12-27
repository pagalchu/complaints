package com.le.viet.vault.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rs")
public class DashboardController {
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping(){
		return "pong";
	}
}
