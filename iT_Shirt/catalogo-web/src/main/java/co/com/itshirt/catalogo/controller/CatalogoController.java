package co.com.itshirt.catalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador de inicio del módulo de catalogo.
 * @author ja.picon
 *
 */
@Controller
@RequestMapping("/")
public class CatalogoController {
	
	/**
	 * Método inicial.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
	    return "home";
   }
	
}