package com.dred.spring.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/banco")
public class IndexController {
	
	@GetMapping({"/index","/","/home"})
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo","Primera aplicacion web con Spring MVC");
		mv.addObject("mensaje", "Hola desde Spring!");
		mv.setViewName("index");
		return mv;
	}
}
