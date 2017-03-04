package co.com.itshirt.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Clase de ejemplo controlador Spring.
 * 
 * @author Julián Picón
 * @since 04/03/2017
 */
@Controller
@RequestMapping("/hello")
public class EjemploController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("message", "Hello World!");
		return "hello";
	}
	
}
