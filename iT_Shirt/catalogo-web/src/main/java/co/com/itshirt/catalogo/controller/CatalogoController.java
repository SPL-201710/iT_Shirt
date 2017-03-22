package co.com.itshirt.catalogo.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controlador de inicio del módulo de catalogo.
 * @author ja.picon
 *
 */
@Controller
@SessionAttributes("resultadoAutenticacion")
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS )
public class CatalogoController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Método inicial.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(value = {"/", "catalogo"}, method = RequestMethod.GET)
	public String verCatalogo(ModelMap model, HttpSession session) {
//		ResultadoAutenticacionDTO resultadoAutenticacion = (ResultadoAutenticacionDTO) model.get("resultadoAutenticacion");
//		System.out.println("User aut enviado: "+resultadoAutenticacion.getUsuario());
		System.out.println("User aut enviado: "+model.containsAttribute("resultadoAutenticacion"));
		System.out.println("session: " + session.getAttribute("resultadoAutenticacion"));
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