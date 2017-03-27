package co.com.itshirt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtistaController {
	@RequestMapping(value="artistas", method = RequestMethod.GET)
	public String verArtistas(ModelMap model, HttpSession session)
	{
		return "artistas";
	}
	
	@RequestMapping(value="addArtista", method = RequestMethod.GET)
	public String addArtista(ModelMap model, HttpSession session)
	{
		return "addartista";
	}
}
