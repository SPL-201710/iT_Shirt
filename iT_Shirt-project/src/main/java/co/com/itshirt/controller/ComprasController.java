package co.com.itshirt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.repository.OrdenCompraRepository;
import co.com.itshirt.security.CustomUserDetails;


@Controller
@RequestMapping("/compras")
public class ComprasController {
	
	@Autowired
	private OrdenCompraRepository ordenCompraRepository;
	
	@RequestMapping(value= "historial", method = RequestMethod.GET)
	public String metodoPago(ModelMap model, HttpSession session) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		model.addAttribute("compras", this.ordenCompraRepository.findByIdUsuario(usuario.getIdUsuario()));
		return "compra/historial";
	}
	
}
