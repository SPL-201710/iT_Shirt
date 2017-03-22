package co.com.itshirt.autenticacion.controller;

import java.io.Serializable;
import java.net.MalformedURLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import co.com.itshirt.api.dto.usuario.LoginDTO;
import co.com.itshirt.api.dto.usuario.ResultadoAutenticacionDTO;
import co.com.itshirt.api.util.StringUtils;
import co.com.itshirt.service.UsuarioServicio;

/**
 * Controlador de inicio del módulo de autenticación.
 * @author ja.picon
 *
 */
@Controller
public class AutenticacionController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	/**
	 * Método inicial.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
		return new ModelAndView("login", "login", new LoginDTO());
	}
	
	@RequestMapping(value="verCatalogo",method = RequestMethod.GET)  
    public ModelAndView verCatalogo(ModelMap model, HttpSession session,SessionStatus status,HttpServletRequest request) throws RestClientException, MalformedURLException {
		ModelAndView mv = new ModelAndView(new RedirectView("/catalogo-web/catalogo", false), model);
		session.setAttribute("autenticacion", SecurityContextHolder.getContext().getAuthentication());
		//ModelAndView mv = new ModelAndView(new RedirectView("/autenticacion-web/perfil", false), model);
		RestTemplate restTemplate = new RestTemplate();
        String st = restTemplate.getForObject(StringUtils.getURLBase(request) +"/autenticacion-web/rest/autenticacion", String.class);
        System.out.println(st);
		return  mv;
    }
	
	
	
	/**
	 * Método home.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model, HttpSession session,SessionStatus status) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		return "home";
	}

}
