package co.com.itshirt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.itshirt.config.VariabilityConfig;
import co.com.itshirt.domain.DetalleOrden;
import co.com.itshirt.domain.OrdenCompra;
import co.com.itshirt.repository.DetalleOrdenRepository;
import co.com.itshirt.repository.OrdenCompraRepository;
import co.com.itshirt.repository.vip.DetalleOrdenVIPRepository;
import co.com.itshirt.repository.EstampaRepository;
import co.com.itshirt.repository.UserRepository;
import co.com.itshirt.security.CustomUserDetails;
import co.com.itshirt.variability.delegation.EstampasControllerVIP;


@Controller
@RequestMapping("/compras")
public class ComprasController {
	
	@Autowired
	private OrdenCompraRepository ordenCompraRepository;
	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;
	@Autowired
	private DetalleOrdenVIPRepository detalleOrdenVIPRepository;
	@Autowired
	private EstampaRepository estampaRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	protected VariabilityConfig variabilityConfig;
	
	@RequestMapping(value= "historial", method = RequestMethod.GET)
	public String historial(ModelMap model, HttpSession session) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		model.addAttribute("compras", this.ordenCompraRepository.findByIdUsuario(usuario.getIdUsuario()));
		return "compra/historial";
	}
	
	@RequestMapping(value= "/detalle", method = RequestMethod.GET)
	public String verDetalleCompra(@RequestParam(value="es", required=true) Long idOrdenCompra, ModelMap model, HttpSession session) {
    	final OrdenCompra ordenCompra = this.ordenCompraRepository.findOne(idOrdenCompra);
    	model.addAttribute("idOrdenCompra", idOrdenCompra);
    	final List<DetalleOrden> detallesOrden = this.detalleOrdenRepository.findByOrdenCompra(ordenCompra);
    	if (detallesOrden != null && !detallesOrden.isEmpty()) {
    		model.addAttribute("detallesOrden", detallesOrden);
    	} else {
    		model.addAttribute("detallesOrdenVIP", this.detalleOrdenVIPRepository.findByOrdenCompra(ordenCompra));
    	}
    	model.addAttribute("ratingVar", this.variabilityConfig.isRatingVar());
    	
    	//final usuario = this.userRepository.findOne(arg0)
		return "compra/detalleCompra";
	}
	
	@RequestMapping(value= "historial/vip", method = RequestMethod.GET)
	public String historialVIP(ModelMap model, HttpSession session) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		model.addAttribute("compras", this.ordenCompraRepository.findByIdUsuario(usuario.getIdUsuario()));
		return "compra/historial";
	}
	
	@RequestMapping(value="/calificarEstampa", method = RequestMethod.POST)
	public String calificarEstampaVIP(@RequestParam(value="ord", required=true) Long idOrden, @RequestParam(value="est", required=true) Long idEst, 
			@RequestParam(value="calif", required=true) String calif, Model model, final RedirectAttributes redirectAttributes){
		
		if(this.variabilityConfig.isRatingVar())
		{
			EstampasControllerVIP estampaVIP = new EstampasControllerVIP(userRepository, estampaRepository);
			return estampaVIP.calificarEstampaVIP(idOrden, idEst, calif, redirectAttributes);
		}
		return "redirect:/compras/detalle?es=" + idOrden;
	}
	@RequestMapping(value="/detalle/calificarEstampa", method = RequestMethod.POST)
	public String calificarEstampaVIPListado(@RequestParam(value="ord", required=true) Long idOrden, @RequestParam(value="est", required=true) Long idEst, 
			@RequestParam(value="calif", required=true) String calif, Model model, final RedirectAttributes redirectAttributes){
		
		if(this.variabilityConfig.isRatingVar())
		{
			EstampasControllerVIP estampaVIP = new EstampasControllerVIP(userRepository, estampaRepository);
			return estampaVIP.calificarEstampaVIP(idOrden, idEst, calif, redirectAttributes);
		}
		return "redirect:/compras/detalle?es=" + idOrden;
	}
	
}
