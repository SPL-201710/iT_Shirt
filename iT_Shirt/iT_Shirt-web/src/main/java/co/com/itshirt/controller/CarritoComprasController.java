package co.com.itshirt.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.domain.DetalleOrden;
import co.com.itshirt.domain.OrdenCompra;
import co.com.itshirt.domain.vip.DetalleOrdenVIP;
import co.com.itshirt.enums.EnumEstadoCompra;
import co.com.itshirt.repository.DetalleOrdenRepository;
import co.com.itshirt.repository.OrdenCompraRepository;
import co.com.itshirt.repository.vip.DetalleOrdenVIPRepository;
import co.com.itshirt.security.CustomUserDetails;


@Controller
@RequestMapping("/carrito")
public class CarritoComprasController {
	
	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;
	@Autowired
	private DetalleOrdenVIPRepository detalleOrdenVIPRepository;
	@Autowired
	private OrdenCompraRepository ordenCompraRepository;
	
	@RequestMapping(value= {"/", ""}, method = RequestMethod.GET)
	public String carritoCompras(ModelMap model, HttpSession session) {
		Long subTotal = 0L;
		Long envioEstimado = 0L;
		Long total = 0L;
		if (session.getAttribute("elementosCarrito")!=null) {
			ArrayList<DetalleOrden> elementosCarrito = (ArrayList<DetalleOrden>) session.getAttribute("elementosCarrito");
			for (DetalleOrden detalleOrden : elementosCarrito) {
				subTotal += detalleOrden.getPrecioTotalCalculado();
				total += detalleOrden.getPrecioTotalCalculado();
			}
		}
		session.setAttribute("subTotal", subTotal);
		session.setAttribute("envioEstimado", envioEstimado);
		session.setAttribute("total", total);
		return "compra/carrito";
	}
	
	@RequestMapping(value= "metodoPago", method = RequestMethod.GET)
	public String metodoPago(ModelMap model, HttpSession session) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
    	model.addAttribute("rolUser", usuario.getRol());
		return "compra/metodoPago";
	}
	
	@RequestMapping(value= "pago", method = RequestMethod.GET)
	public String paginaPago(ModelMap model, HttpSession session) {
		return "compra/payment";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value= "realizarPago", method = RequestMethod.GET)
	public String realizarPago(ModelMap model, HttpSession session) {
		if (session.getAttribute("elementosCarrito") !=null ) {
			System.err.println("Registrando un pago desde el carrito.");
			final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
			OrdenCompra ordenCompra = new OrdenCompra();
			ordenCompra.setDireccionEnvio("Calle Falsa 123"); //TODO Ajustar
			ordenCompra.setFecha(new Date());
			ordenCompra.setEstado(EnumEstadoCompra.PROCESADO.getSigla());
			ordenCompra.setIdUsuario(usuario.getIdUsuario());
			ordenCompra.setTelefonoContacto(usuario.getTelefono());
			ordenCompra.setTotal((Long)session.getAttribute("total"));
			ordenCompra = this.ordenCompraRepository.save(ordenCompra);
			long idOrden = ordenCompra.getIdOrdenCompra();
			ArrayList<DetalleOrden> elementosCarrito = (ArrayList<DetalleOrden>) session.getAttribute("elementosCarrito");
			for (DetalleOrden detalleOrden : elementosCarrito) {
				detalleOrden.setOrdenCompra(ordenCompra);
				detalleOrden.setPrecioCamiseta(detalleOrden.getEstiloCamiseta().getPrecio());
				detalleOrden.setPrecioEstampa(detalleOrden.getEstampa().getPrecio());
				this.detalleOrdenRepository.save(detalleOrden);
			}
			session.removeAttribute("elementosCarrito");
			return "redirect:/compras/detalle?es=" + idOrden;
		} else if (session.getAttribute("compraVIP") !=null ) {
			System.err.println("Registrando un pago compra VIP.");
			final DetalleOrdenVIP ordenVIP = (DetalleOrdenVIP) session.getAttribute("compraVIP");
			final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
			OrdenCompra ordenCompra = new OrdenCompra();
			ordenCompra.setDireccionEnvio("N/A");
			ordenCompra.setFecha(new Date());
			ordenCompra.setEstado(EnumEstadoCompra.PROCESADO.getSigla());
			ordenCompra.setIdUsuario(usuario.getIdUsuario());
			ordenCompra.setTelefonoContacto(usuario.getTelefono());
			ordenCompra.setTotal(ordenVIP.getPrecio());
			ordenCompra = this.ordenCompraRepository.save(ordenCompra);
			//Guardando relacion entre orden y detalle orden.
			ordenVIP.setOrdenCompra(ordenCompra);
			this.detalleOrdenVIPRepository.save(ordenVIP);
			session.removeAttribute("elementosCarrito");
		}
		
		return "redirect:/";
	}
	
}
