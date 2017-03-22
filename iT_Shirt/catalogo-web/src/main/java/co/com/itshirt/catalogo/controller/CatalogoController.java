package co.com.itshirt.catalogo.controller;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import co.com.itshirt.api.util.StringUtils;

/**
 * Controlador de inicio del módulo de catalogo.
 * @author ja.picon
 *
 */
@Controller
@SessionAttributes("resultadoAutenticacion")
public class CatalogoController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Método inicial.
	 * @return Nombre de la página a redireccionar.
	 * @throws MalformedURLException 
	 */
	@RequestMapping(value = {"/", "catalogo"}, method = RequestMethod.GET)
	public String verCatalogo(ModelMap model, HttpSession session, HttpServletRequest request) throws MalformedURLException {
		RestTemplate restTemplate = new RestTemplate();
        String st = restTemplate.getForObject(StringUtils.getURLBase(request) +"/autenticacion-web/rest/autenticacion", String.class);
        System.out.println(st);
	    return "home";
   }
	
	/**
	 * Método inicial.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(value = {"/", "cat-web"}, method = RequestMethod.GET)
	public String verCatWeb(ModelMap model, HttpSession session) {
	    return "catweb";
   }
}