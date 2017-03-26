package co.com.itshirt.controller;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EstampasController {
	
	@RequestMapping(value="catalogo", method = RequestMethod.GET)
	public String verEstampas(ModelMap model, HttpSession session)
	{
		return "catalogo";
	}
	
	@RequestMapping(value="addEstampa", method = RequestMethod.GET)
	public String addEstampa(ModelMap model, HttpSession session)
	{
		return "addestampa";
	}
	
}
