package co.com.itshirt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ReportesController {
	
	@RequestMapping(value="/admin/reportes", method = RequestMethod.GET)
	public String reportesAdministrador(ModelMap model, HttpSession session) {
		return "reporte/reportes";
	}
	
	@RequestMapping(value="/artista/reportes", method = RequestMethod.GET)
	public String reportesArtista(ModelMap model, HttpSession session) {
		return "reporte/reportes";
	}
	
}
