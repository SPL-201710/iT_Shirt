package co.com.itshirt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin")
public class AdministracionController {
	
	@RequestMapping(value="usuarios", method = RequestMethod.GET)
	public String usuarios(ModelMap model, HttpSession session) {
		return "usuario/listadoUsuarios";
	}
	
	@RequestMapping(value="temas", method = RequestMethod.GET)
	public String temas(ModelMap model, HttpSession session) {
		return "tema/listadoTemas";
	}
	
	@RequestMapping(value="estampas", method = RequestMethod.GET)
	public String estampas(ModelMap model, HttpSession session) {
		return "catalogo";
	}
	
	@RequestMapping(value="reportes", method = RequestMethod.GET)
	public String reportes(ModelMap model, HttpSession session) {
		return "reporte/reportes";
	}
	
}
