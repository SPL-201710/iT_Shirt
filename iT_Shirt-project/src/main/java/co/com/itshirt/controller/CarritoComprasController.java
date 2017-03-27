package co.com.itshirt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/carrito")
public class CarritoComprasController {
	
	@RequestMapping(value= {"/", ""}, method = RequestMethod.GET)
	public String carritoCompras(ModelMap model, HttpSession session) {
		return "compra/carrito";
	}
	
	@RequestMapping(value= "metodoPago", method = RequestMethod.GET)
	public String metodoPago(ModelMap model, HttpSession session) {
		return "compra/metodoPago";
	}
	
	@RequestMapping(value= "pago", method = RequestMethod.GET)
	public String realizarPago(ModelMap model, HttpSession session) {
		return "compra/payment";
	}
	
}
