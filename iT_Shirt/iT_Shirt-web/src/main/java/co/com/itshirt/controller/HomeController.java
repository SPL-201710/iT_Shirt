package co.com.itshirt.controller;

import java.io.File;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.config.MenuBuilder;
import co.com.itshirt.config.VariabilityConfig;
import co.com.itshirt.repository.UserRepository;
import co.com.itshirt.repository.service.SecurityService;
import co.com.itshirt.security.CustomUserDetails;

/**
 * Controlador funcionalidades página de inicio.
 */
@Controller
public class HomeController {
	
	final static String ANONYMOUS_USER = "anonymousUser";
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SecurityService securityService;
	@Autowired
	protected VariabilityConfig variabilityConfig;
	@Autowired
	protected MenuBuilder menuBuilder;
	
	/**
	 * Método que se encarga se ejecutar la petición raíz del proyecto, 
	 * validando si existe un usuario logueado o no, para determinar la redirección.
	 */
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model, HttpSession session, HttpServletRequest request) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String filePath = request.getServletContext().getRealPath("/"); 
		File newFiles= new File(request.getSession().getServletContext().getRealPath("/WEB-INF/files/"), "test.png");
		String realPath = request.getRealPath("/somefile.txt");
		System.err.println( newFiles);
		System.err.println( filePath);
		System.err.println("Información de prueba!");
		
		this.cargarConfiguracionEnSesion(session);
		
		if (!authentication.getName().equals(ANONYMOUS_USER)) {
			System.err.println(authentication.getPrincipal());
			CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
			if (usuario.getIdUsuario() == null) { //Por si viene desde conexión red social
				usuario = new CustomUserDetails(this.userRepository.findByUsername(usuario.getUsername()));
				this.securityService.autologin(usuario.getUsername(), usuario.getPassword());
			}
			final String rol = usuario.getRol().getNombre();
			session.setAttribute("nombreCompleto", usuario.getNombresCompletos());
			session.setAttribute("genero", usuario.getGenero());
			session.setAttribute("rol", rol);
			session.setAttribute("menus", this.menuBuilder.obtenerMenusPorRol(usuario.getRol().getNombre()));
			return "welcome";
		} else {
			return "home";
		}
		
	}

	private void cargarConfiguracionEnSesion(HttpSession session) {
		session.setAttribute("authFacebook", this.variabilityConfig.isAuthFacebook());
		session.setAttribute("advancedSearch", this.variabilityConfig.isAdvancedSearch());
		session.setAttribute("notifications", this.variabilityConfig.isNotifications());
		session.setAttribute("changePassword", this.variabilityConfig.isChangePassword());
		session.setAttribute("vip", this.variabilityConfig.isVip());
		
		session.setAttribute("rateProducts", this.variabilityConfig.isRateProducts());
		session.setAttribute("authTwitter", this.variabilityConfig.isAuthTwitter());
		session.setAttribute("shareOnSocialNetwork", this.variabilityConfig.isShareOnSocialNetwork());
		session.setAttribute("facebook", this.variabilityConfig.isFacebook());
		session.setAttribute("twitter", this.variabilityConfig.isTwitter());
		session.setAttribute("designsByArtist", this.variabilityConfig.isDesignsByArtist());
		session.setAttribute("byArtist", this.variabilityConfig.isByArtist());
		
	}

}
