package cn.edu.ruc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping
@Controller
public class IndexController {
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView view =new ModelAndView("/index");
		return view;
	}
}
