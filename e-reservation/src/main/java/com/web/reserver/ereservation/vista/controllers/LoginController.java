/**
 * 
 */
package com.web.reserver.ereservation.vista.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controlador de login personalizado
 * @author sumel
 *
 */
@Controller
@RequestMapping("app")
public class LoginController {
	@GetMapping(value = {"/login", "/"})
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		String errorMessage = "Usuario incorrecto";
		modelAndView.addObject("errorMsg", errorMessage);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
}
