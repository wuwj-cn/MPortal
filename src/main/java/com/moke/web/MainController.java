package com.moke.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Proudly handcrafted by " + "<a href='http://52.192.154.86/jenkins'>moke jenkins</a> :)";
	}
}
