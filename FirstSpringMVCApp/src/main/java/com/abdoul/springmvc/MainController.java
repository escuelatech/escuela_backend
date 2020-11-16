package com.abdoul.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    
	@RequestMapping("/info")
	public String message() {
		return "index";
		
	}
}
