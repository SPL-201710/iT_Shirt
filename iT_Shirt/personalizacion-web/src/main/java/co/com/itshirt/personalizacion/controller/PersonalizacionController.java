package co.com.itshirt.personalizacion.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador de inicio del módulo de personalizacion.
 * @author ja.picon
 *
 */
@Controller
public class PersonalizacionController {
	
	/**
	 * Método inicial.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(value = {"/", "personalizacion"}, method = RequestMethod.GET)
	public String home(ModelMap model) {
	    return "home";
   }
	
}