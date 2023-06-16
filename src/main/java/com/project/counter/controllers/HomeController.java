package com.project.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		
		Integer count = 0;
		
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}

}
