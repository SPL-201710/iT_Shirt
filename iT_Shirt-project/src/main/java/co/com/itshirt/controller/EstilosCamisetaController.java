package co.com.itshirt.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.EstiloCamiseta;
import co.com.itshirt.dto.EstampaDTO;
import co.com.itshirt.dto.EstiloCamisetaDTO;
import co.com.itshirt.enums.EnumEstilosCamiseta;
import co.com.itshirt.repository.EstiloCamisetaRepository;

/**
 * Funcionalidades de las camisetas.
 */
@Controller
@RequestMapping("camisetas")
public class EstilosCamisetaController {
	
	@Autowired
	private EstiloCamisetaRepository estiloCamisetaRepository;
	
	/**
	 * Ver todo el catalogo de estampas.
	 */
	@RequestMapping(value="catalogo", method = RequestMethod.GET)
	public String verEstampas(ModelMap model, HttpSession session) {
		List<EstiloCamisetaDTO> estilos = new ArrayList<EstiloCamisetaDTO>();
    	Iterable<EstiloCamiseta> lstEntities = this.estiloCamisetaRepository.findAll();
    	if (lstEntities != null) {
    		for (final EstiloCamiseta estiloCamiseta : lstEntities) {
    			estilos.add(new EstiloCamisetaDTO(estiloCamiseta));
    		}
    	}
    	model.addAttribute("camisetas", estilos);
		return "camiseta/catalogoCamisetas";
	}
	
	/**
	 * Ver todo el catalogo de estampas.
	 */
	@RequestMapping(value="agregarCamiseta", method = RequestMethod.GET)
	public String agregarCamiseta(ModelMap model, HttpSession session) {
		Map<String,String> estilos = new LinkedHashMap<String,String>(); //Para leerlo de <form:options> toca así.
		for (EnumEstilosCamiseta estilo : EnumEstilosCamiseta.ENUM_VALUES) {
			estilos.put(estilo.getSigla(), estilo.getNombre());
		}
		model.addAttribute("estilos", estilos);
		model.addAttribute("camisetaForm", new EstiloCamisetaDTO());
		return "camiseta/creacionEstiloCamiseta";
	}
	
	/**
	 * Método llamado al momento de guardar el formulario de creación.
	 */
	@RequestMapping(value = "agregarCamiseta", method = RequestMethod.POST)
	public String checkAgregarCamiseta(@Valid EstiloCamisetaDTO camiseta, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			System.err.println(bindingResult.getFieldErrors());
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("estampaForm", camiseta);
			return "camiseta/creacionEstiloCamiseta";
		}
		EstiloCamiseta estiloCamiseta = camiseta.toEntity();
		this.estiloCamisetaRepository.save(estiloCamiseta);
		return "redirect:/camisetas/catalogo";
	}
	
	/**
	 * Se encarga de cargar la pagina de detalle de la estampa
	 */
	@RequestMapping(value="/detalleCamiseta", method = RequestMethod.GET)
	public String detalleEstampa(@RequestParam(value="es", required=true) Long es, Model model){
		final EstiloCamiseta estiloCamiseta = this.estiloCamisetaRepository.findOne(es);
		model.addAttribute("estiloCamiseta", new EstiloCamisetaDTO(estiloCamiseta));
		return "camiseta/detalleEstiloCamiseta";
	}
	
	
}
