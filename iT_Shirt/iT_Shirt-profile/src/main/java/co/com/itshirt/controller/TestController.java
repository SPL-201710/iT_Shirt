package co.com.itshirt.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class TestController {
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public String usuarios(ModelMap model, HttpSession session) {
		return "profile/test";
	}
}