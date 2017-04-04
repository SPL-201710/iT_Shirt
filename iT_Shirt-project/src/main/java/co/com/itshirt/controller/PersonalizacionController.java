package co.com.itshirt.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.com.itshirt.domain.DetalleOrden;
import co.com.itshirt.dto.PersonalizacionDTO;
import co.com.itshirt.enums.EnumEstilosCamiseta;
import co.com.itshirt.repository.EstampaRepository;
import co.com.itshirt.repository.EstiloCamisetaRepository;
import co.com.itshirt.repository.OrdenCompraRepository;
import co.com.itshirt.repository.DetalleOrdenRepository;

@Controller
public class PersonalizacionController {
	
	@Autowired
	private DetalleOrdenRepository personalizacionRepository;
	
	@Autowired
	private EstampaRepository estampaRepository;
	
	@Autowired
	private EstiloCamisetaRepository estiloCamisetaRepo;
	
	@Autowired
	private OrdenCompraRepository ordenCompraRepo;
	
	/**
	 * Se encarga de guardar en sesion el id estampa seleccionada y redirige a seleccionar camiseta.
	 */
	@RequestMapping(value="/seleccionCamiseta", method = RequestMethod.GET)
	public String detalleEstampa(@RequestParam(value="es", required=true) Long idEstampaSeleccionada, Model model, HttpSession session, @RequestParam(value="url", required=true) String url ){
		session.setAttribute("idEstampaSeleccionada", idEstampaSeleccionada);
		session.setAttribute("url", url);
		return "redirect:/camisetas/catalogo";
	}
	
	/**
	 * Ver página creación de personalización.
	 */
	@RequestMapping(value="personalizacion", method = RequestMethod.GET)
	public String agregarPersonalizacion(ModelMap model, HttpSession session) {
		Map<String,String> estilos = new LinkedHashMap<String,String>(); 
		for (EnumEstilosCamiseta estilo : EnumEstilosCamiseta.ENUM_VALUES) {
			estilos.put(estilo.getSigla(), estilo.getNombre());
		}
		final PersonalizacionDTO personaliFrom = (PersonalizacionDTO) session.getAttribute("personalizacionDTO");
		personaliFrom.setEstampa( (Long) session.getAttribute("idEstampaSeleccionada"));
		model.addAttribute("personalizacionForm", personaliFrom);
		return "personalizacion/personalizacion";
	}
	
	/**
	 * Método llamado al momento de guardar el formulario de creación.
	 */
	@RequestMapping(value="personalizacion", method = RequestMethod.POST)
	public String checkAgregarPersonalizacion(@Valid PersonalizacionDTO personalizacion, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session) {
		if (bindingResult.hasErrors()) {
			System.err.println(bindingResult.getFieldErrors());
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("personalizacionForm", personalizacion);
			return "personalizacion/personalizacion";
		}
		System.err.println("estampa: " +personalizacion.getEstampa());
		System.err.println("estilo camiseta: " +personalizacion.getEstiloCamiseta());
		DetalleOrden personalizacionSave = personalizacion.toEntity();
		personalizacionSave.setEstampa(this.estampaRepository.findOne(personalizacion.getEstampa()));
		personalizacionSave.setEstiloCamiseta(this.estiloCamisetaRepo.findOne(personalizacion.getEstiloCamiseta()));
//		personalizacionSave.setOrdenCompra(this.ordenCompraRepo.findOne(personalizacion.getOrdenCompra()));
		
		if (session.getAttribute("elementosCarrito")==null){ //Guardado en memoria.
			session.setAttribute("elementosCarrito", new ArrayList());
		}
		ArrayList<DetalleOrden> elementosCarrito = (ArrayList) session.getAttribute("elementosCarrito");
		elementosCarrito.add(personalizacionSave);
		session.setAttribute("elementosCarrito", elementosCarrito);
//		this.personalizacionRepository.save(personalizacionSave);
		return "redirect:/carrito";
	}
}
