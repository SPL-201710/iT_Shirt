package co.com.itshirt.controller.vip;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.itshirt.domain.DetalleOrden;
import co.com.itshirt.domain.vip.DetalleOrdenVIP;
import co.com.itshirt.domain.vip.SuscripcionVIP;
import co.com.itshirt.dto.vip.SuscripcionVIPDTO;
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
		model.addAttribute("suscripciones", this.suscripcionVIPRepository.findAllOrderId());
		model.addAttribute("rolUser", usuario.getRol());
		return "vip/listado";
	}
	
	/**
	 * Listado de suscripciones del administrador.
	 */
	@RequestMapping(value="/admin/suscripcion/crear", method = RequestMethod.GET)
	public String crearSuscripcion(ModelMap model, HttpSession session) {
    	model.addAttribute("paqueteForm", new SuscripcionVIPDTO());
		return "vip/creacionPaqueteVIP";
	}
	
	/**
	 * Listado de suscripciones del administrador.
	 */
	@RequestMapping(value="/admin/suscripcion/crear", method = RequestMethod.POST)
	public String checkCrearSuscripcion(@Valid SuscripcionVIPDTO creacionPaquete, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("paqueteForm", creacionPaquete);
			return "vip/creacionPaqueteVIP";
		}
		final SuscripcionVIP suscripcion = creacionPaquete.toEntity();
		suscripcion.setEstado(EnumEstado.ACTIVO.getSigla());
		this.suscripcionVIPRepository.save(suscripcion);
		return "redirect:/admin/suscripcion";
	}
	
	@RequestMapping(value="/admin/suscripcion/inactivar", method = RequestMethod.POST)
	public String inactivarSuscripcion(@RequestParam(value="id", required=false) Long idSuscripcion, 
			Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes){
		this.suscripcionVIPRepository.updateEstado(EnumEstado.INACTIVO.getSigla(), idSuscripcion);
		redirectAttributes.addFlashAttribute("info", "El paquete ha sido inactivado y ya no estará visible para los Artistas.");
		return "redirect:/admin/suscripcion";
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
	
	@RequestMapping(value="/suscripcion/comprar", method = RequestMethod.POST)
	public String agregarSuscripcionCarrito(@RequestParam(value="id", required=false) Long idSuscripcion, 
			Model model, HttpServletRequest request, HttpSession session){
		final SuscripcionVIP suscripcion = this.suscripcionVIPRepository.findOne(idSuscripcion);
		DetalleOrdenVIP detalleOrdenVIP = new DetalleOrdenVIP();
		detalleOrdenVIP.setSuscripcion(suscripcion);
		detalleOrdenVIP.setPrecio(suscripcion.getPrecio());
		session.setAttribute("compraVIP", detalleOrdenVIP);
		return "redirect:/metodoPago";
	}
	
}
