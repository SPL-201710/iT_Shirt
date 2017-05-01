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

import co.com.itshirt.config.VariabilityConfig;
import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.dto.CreacionEstampaDTO;
import co.com.itshirt.dto.EstampaDTO;
import co.com.itshirt.dto.TemaDTO;
import co.com.itshirt.enums.EnumEstadoEstampa;
import co.com.itshirt.enums.EnumRol;
import co.com.itshirt.repository.EstampaRepository;
import co.com.itshirt.repository.TemaRepository;
import co.com.itshirt.security.CustomUserDetails;
import co.com.itshirt.util.FileUtils;
import co.com.itshirt.variability.factory.BusquedaCatalogo;
import co.com.itshirt.variability.factory.BusquedaFactory;

/**
 * Funcionalidades de las Estampas.
 */
@Controller
public class EstampasController {
	
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private EstampaRepository estampaRepository;
	@Autowired
	protected VariabilityConfig variabilityConfig;
	
	/**
	 * Ver todo el catalogo de estampas.
	 */
	@RequestMapping(value="catalogo", method = RequestMethod.GET)
	public String verEstampas(@RequestParam(value="id", required=false) Tema idTema, ModelMap model, HttpSession session) {
		final BusquedaCatalogo busquedaCatalogo = BusquedaFactory.getBusqueda(this.variabilityConfig.isBusquedaAvanzada());
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
    	Iterable<Estampa> lstEntities = null;
    	List<EstampaDTO> estampas = new ArrayList<EstampaDTO>();
    	
    	if(idTema != null)
    	{
    		lstEntities = this.estampaRepository.findByTema(idTema);
    		
    	}
    	else if (EnumRol.ARTISTA.getSigla().equals(usuario.getRol().getSigla())) {
    		lstEntities = this.estampaRepository.findByArtistaOrderByIdEstampaDesc(usuario);
    	} else {
    		lstEntities = this.estampaRepository.findAll();
    	}
    	
    	if (lstEntities != null) {
    		for (final Estampa estampa : lstEntities) {
    			estampas.add(new EstampaDTO(estampa));
    		}
    	}
    	
    	//Temas para el filtro por temas
    	final Iterable<Tema> temas = this.temaRepository.findAll();
		List<TemaDTO> listTemas = new ArrayList<TemaDTO>();
		for (final Tema tema : temas) {
			listTemas.add(new TemaDTO(tema));
		}
		
		model.addAttribute("temas", listTemas);
    	model.addAttribute("estampas", estampas);
    	model.addAttribute("busqueda", busquedaCatalogo);
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
		estampaNueva.setEstaNombreCorto(creacionEstampa.getEstaNombreCorto());
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
	@RequestMapping(value="/estampa/editar", method = RequestMethod.GET)
	public String verEditarEstampa(@RequestParam(value="es", required=true) Long idEstampaEditar, Model model, HttpSession session){
		final Iterable<Tema> temas = this.temaRepository.findAll();
		Map<Long,String> mapTemas = new LinkedHashMap<Long,String>(); //Para leerlo de <form:options> toca así.
		for (Tema tema : temas) {
			mapTemas.put(tema.getIdTema(), tema.getNombre());
		}
		final Estampa estampa = this.estampaRepository.findOne(idEstampaEditar);
		session.setAttribute("idEstampaEditar", idEstampaEditar);
		model.addAttribute("temas", mapTemas);
		model.addAttribute("estampaForm", new CreacionEstampaDTO(estampa)); //Se llena DTO para pre cargar información
		return "estampa/edicionEstampa";
	}
	
	/**
	 * Método llamado al momento de guardar el formulario de creación.
	 */
	@RequestMapping(value = "/estampa/editar", method = RequestMethod.POST)
	public String checkEditarEstampa(@Valid CreacionEstampaDTO edicionEstampa, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("estampaForm", edicionEstampa);
			return "estampa/edicionEstampa";
		}
		final Long idEstampa = (Long) session.getAttribute("idEstampaEditar");
		final Estampa estampa = this.estampaRepository.findOne(idEstampa);
		estampa.setEstaNombreCorto(edicionEstampa.getEstaNombreCorto());
		estampa.setDescripcion(edicionEstampa.getDescripcion());
		estampa.setPrecio(edicionEstampa.getPrecio());
		estampa.setTema(this.temaRepository.findOne(edicionEstampa.getIdTema()));
		this.estampaRepository.save(estampa);
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
