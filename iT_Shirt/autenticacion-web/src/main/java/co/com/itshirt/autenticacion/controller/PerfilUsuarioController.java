package co.com.itshirt.autenticacion.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.service.UsuarioServicio;

/**
 * Controlador perfil de usuario.
 * @author ja.picon
 * @since 29/03/2017
 *
 */
@Controller
@RequestMapping("/perfil")
public class PerfilUsuarioController {
	
	/**
	 * Inyección dependencia funcionalidades Usuario.
	 */
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	/**
	 * Método inicial del controlador.
	 */
	@PostConstruct
	public void init() {
		
	}

	/**
	 * Cargando página perfil usuario.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model, HttpSession session, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		System.out.println("User aut enviado: "+model.containsAttribute("resultadoAutenticacion"));
		System.out.println("Obje: "+model.get("resultadoAutenticacion"));
		System.out.println("session: " + session.getAttribute("resultadoAutenticacion"));
		return "perfil/perfil";
	}
	
}