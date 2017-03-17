package co.com.itshirt.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador de inicio del módulo de administración.
 * @author ja.picon
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	/**
	 * Método inicial.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
	    return "home";
   }
	
}
