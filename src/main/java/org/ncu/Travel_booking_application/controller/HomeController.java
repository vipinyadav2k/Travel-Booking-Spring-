package org.ncu.Travel_booking_application.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.ncu.Travel_booking_application.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@ModelAttribute("User")
	public User getuser()
	{
		return new User();
	}
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("Login2");
	}
}
