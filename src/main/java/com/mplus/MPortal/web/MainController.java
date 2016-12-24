package com.mplus.MPortal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
//	@ResponseBody
	public String index() {
		return "redirect:index.html";
	}
}
