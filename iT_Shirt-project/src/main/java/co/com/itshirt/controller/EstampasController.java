package co.com.itshirt.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.dto.CreacionEstampaDTO;
import co.com.itshirt.dto.EstampaDTO;
import co.com.itshirt.enums.EnumEstadoEstampa;
import co.com.itshirt.enums.EnumRol;
import co.com.itshirt.repository.EstampaRepository;
import co.com.itshirt.repository.TemaRepository;
import co.com.itshirt.security.CustomUserDetails;
import co.com.itshirt.util.FileUtils;

/**
 * Funcionalidades de las Estampas.
 */
@Controller
public class EstampasController {
	
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private EstampaRepository estampaRepository;
	
	/**
	 * Ver todo el catalogo de estampas.
	 */
	@RequestMapping(value="catalogo", method = RequestMethod.GET)
	public String verEstampas(ModelMap model, HttpSession session) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
    	Iterable<Estampa> listEntities = null;
    	List<EstampaDTO> estampas = new ArrayList<EstampaDTO>();
    	if (EnumRol.ARTISTA.getSigla().equals(usuario.getRol().getSigla())) {
    		listEntities = this.estampaRepository.findByArtistaOrderByIdEstampaDesc(usuario);
    	} else {
    		listEntities = this.estampaRepository.findAll();
    	}
    	if (listEntities != null) {
    		for (final Estampa estampa : listEntities) {
    			estampas.add(new EstampaDTO(estampa));
    		}
    	}
    	model.addAttribute("estampas", estampas);
    	model.addAttribute("roluser", usuario.getRol());
    	System.out.println("rol " + usuario.getRol());
		return "catalogo";
	}
	
	/**
	 * Se encarga de cargar la pagina de creación de estampas.
	 */
	@RequestMapping(value="/crearEstampa", method = RequestMethod.GET)
	public String addEstampa(ModelMap model, HttpSession session) {
		final Iterable<Tema> temas = this.temaRepository.findAll();
		Map<Long,String> mapTemas = new LinkedHashMap<Long,String>(); //Para leerlo de <form:options> toca así.
		for (Tema tema : temas) {
			mapTemas.put(tema.getIdTema(), tema.getNombre());
		}
		model.addAttribute("temas", mapTemas);
		model.addAttribute("estampaForm", new CreacionEstampaDTO());
		return "estampa/creacionEstampa";
	}
	
	/**
	 * Método llamado al momento de guardar el formulario de creación.
	 */
	@RequestMapping(value = "/crearEstampa", method = RequestMethod.POST)
	public String checkCrearEstampa(@Valid CreacionEstampaDTO creacionEstampa, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("estampaForm", creacionEstampa);
			return "estampa/creacionEstampa";
		}
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		Estampa estampaNueva = new Estampa();
		estampaNueva.setArtista(usuario);
		estampaNueva.setDescripcion(creacionEstampa.getDescripcion());
		estampaNueva.setEstado(EnumEstadoEstampa.ACTIVA.getCodigo());
		estampaNueva.setNombreCorto(creacionEstampa.getNombreCorto());
		estampaNueva.setPrecio(creacionEstampa.getPrecio());
		estampaNueva.setTema(this.temaRepository.findOne(creacionEstampa.getIdTema()));
		estampaNueva.setUrl(creacionEstampa.getFile().getOriginalFilename());
		estampaNueva.setExtension(FileUtils.obtenerExtension(creacionEstampa.getFile()));
		estampaNueva = this.estampaRepository.save(estampaNueva); //Para recuperar el ID
		FileUtils.guardarArchivoEstampa(creacionEstampa.getFile(), usuario.getIdUsuario(), estampaNueva.getIdEstampa(), request);
		return "redirect:/catalogo";
	}
	
	/**
	 * Se encarga de cargar la pagina de detalle de la estampa
	 */
	@RequestMapping(value="/detalleEstampa", method = RequestMethod.GET)
	public String detalleEstampa(@RequestParam(value="es", required=true) Long es, Model model){
		final Estampa estampa = estampaRepository.findOne(es);
		model.addAttribute("estampa", new EstampaDTO(estampa));
		return "estampa/detalleEstampa";
	}
	
	/**
	 * Se encarga de cargar la pagina de detalle de la estampa
	 */
	@RequestMapping(value="estampa/calificaciones", method = RequestMethod.GET)
	public String verCalificaciones(Model model){
		return "estampa/calificaciones";
	}
	
}
