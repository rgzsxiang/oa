package com.bwf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {

	@RequestMapping("test1")
	public void test(){
		System.out.println(  "test controller" );
	}
	
}
