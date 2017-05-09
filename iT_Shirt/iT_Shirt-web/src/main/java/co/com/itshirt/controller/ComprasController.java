package co.com.itshirt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.com.itshirt.domain.DetalleOrden;
import co.com.itshirt.domain.OrdenCompra;
import co.com.itshirt.repository.DetalleOrdenRepository;
import co.com.itshirt.repository.OrdenCompraRepository;
import co.com.itshirt.repository.vip.DetalleOrdenVIPRepository;
import co.com.itshirt.security.CustomUserDetails;


@Controller
@RequestMapping("/compras")
public class ComprasController {
	
	@Autowired
	private OrdenCompraRepository ordenCompraRepository;
	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;
	@Autowired
	private DetalleOrdenVIPRepository detalleOrdenVIPRepository;
	
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
		return "compra/detalleCompra";
	}
	
	@RequestMapping(value= "historial/vip", method = RequestMethod.GET)
	public String historialVIP(ModelMap model, HttpSession session) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		model.addAttribute("compras", this.ordenCompraRepository.findByIdUsuario(usuario.getIdUsuario()));
		return "compra/historial";
	}
	
}
