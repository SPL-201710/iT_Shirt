package co.com.itshirt.controller.vip;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.enums.EnumEstado;
import co.com.itshirt.repository.vip.SuscripcionVIPRepository;
import co.com.itshirt.security.CustomUserDetails;


@Controller
public class SuscripcionVIPController {
	
	@Autowired
	private SuscripcionVIPRepository suscripcionVIPRepository;
	
	/**
	 * Listado de suscripciones del administrador.
	 */
	@RequestMapping(value="/admin/suscripcion", method = RequestMethod.GET)
	public String getSuscripciones(ModelMap model, HttpSession session) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		model.addAttribute("suscripciones", this.suscripcionVIPRepository.findAll());
		model.addAttribute("rolUser", usuario.getRol());
		return "vip/listado";
	}
	
	/**
	 * Listado de suscripciones activas
	 */
	@RequestMapping(value="/suscripcion", method = RequestMethod.GET)
	public String getSuscripcionesActivar(ModelMap model, HttpSession session) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		model.addAttribute("suscripciones", this.suscripcionVIPRepository.findByEstado(EnumEstado.ACTIVO.getSigla()));
		model.addAttribute("rolUser", usuario.getRol());
		return "vip/listado";
	}
	
}
