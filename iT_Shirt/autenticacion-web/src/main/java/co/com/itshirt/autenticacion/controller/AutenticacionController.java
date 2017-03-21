package co.com.itshirt.autenticacion.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.itshirt.api.dto.usuario.LoginDTO;
import co.com.itshirt.api.dto.usuario.ResultadoAutenticacionDTO;
import co.com.itshirt.service.UsuarioServicio;

/**
 * Controlador de inicio del módulo de autenticación.
 * @author ja.picon
 *
 */
@Controller
@SessionAttributes("resultadoAutenticacion")
public class AutenticacionController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private UsuarioServicio usuarioServicio;
	private ResultadoAutenticacionDTO resultadoAutenticacion;
	
	/**
	 * Método inicial.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
		return new ModelAndView("login", "login", new LoginDTO());
	}
	
	@RequestMapping(value="login/autenticar",method = RequestMethod.POST)  
    public String loginSubmit(@ModelAttribute LoginDTO login, ModelMap model, HttpSession session,SessionStatus status) {
		System.out.println("Usuario aut: " + login.getUsuario());
		try {
			this.resultadoAutenticacion = this.usuarioServicio.autenticar(login);
			return "redirect:/home";
		} catch (Exception e) {
			e.printStackTrace();
			return "/";
		}
    }

	/**
	 * Método home.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model, HttpSession session,SessionStatus status) {
		return "home";
	}

	
}
