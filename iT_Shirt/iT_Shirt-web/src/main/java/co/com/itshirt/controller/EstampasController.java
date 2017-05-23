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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.itshirt.config.VariabilityConfig;
import co.com.itshirt.domain.DetalleOrden;
import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.domain.Usuario;
import co.com.itshirt.dto.CreacionEstampaDTO;
import co.com.itshirt.dto.EstampaDTO;
import co.com.itshirt.dto.TemaDTO;
import co.com.itshirt.enums.EnumEstadoEstampa;
import co.com.itshirt.enums.EnumRol;
import co.com.itshirt.repository.UserRepository;
import co.com.itshirt.repository.DetalleOrdenRepository;
import co.com.itshirt.repository.EstampaRepository;
import co.com.itshirt.repository.TemaRepository;
import co.com.itshirt.security.CustomUserDetails;
import co.com.itshirt.util.FileUtils;
import co.com.itshirt.variability.component.SSLEmail;
import co.com.itshirt.variability.factory.BusquedaCatalogo;
import co.com.itshirt.variability.factory.BusquedaFactory;
import co.com.itshirt.variability.delegation.*;

/**
 * Funcionalidades de las Estampas.
 */
@Controller
public class EstampasController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private EstampaRepository estampaRepository;
	@Autowired
	protected VariabilityConfig variabilityConfig;
	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;

	/**
	 * Ver todo el catalogo de estampas.
	 */
	@RequestMapping(value="catalogo", method = RequestMethod.GET)
	public String verEstampas(@RequestParam(value="id", required=false) Tema idTema, @RequestParam(value="filter", required=false) Double filter, @RequestParam(value="nom", required=false) String nombre, ModelMap model, HttpSession session) {
		final BusquedaCatalogo busquedaCatalogo = BusquedaFactory.getBusqueda(this.variabilityConfig.isAdvancedSearch());
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
    	
    	Iterable<Estampa> lstEntities = null;
    	Iterable<Estampa> listEstampDest = null;
    	List<EstampaDTO> estampas = new ArrayList<EstampaDTO>();
    	
    	System.out.println(filter);
    	System.out.println(nombre);
    	System.out.println(idTema);
    	
    	if(nombre != null || idTema != null || filter != null)
    	{
    		if(nombre != "" && idTema == null && filter == 0)
        	{
        		estampas = this.buscarEstampasByNombre(nombre);
        		lstEntities = null;
        	}    	    	
        	else if(idTema != null && filter == 0 && nombre.equals(""))
        	{
        		estampas = this.buscarEstampasByTema(idTema);
        		listEstampDest = this.estampaRepository.find(idTema,"A","S");
        		lstEntities = null;
        	}
        	else if (EnumRol.ARTISTA.getSigla().equals(usuario.getRol().getSigla())) {
        		lstEntities = this.estampaRepository.findByArtistaOrderByIdEstampaDesc(usuario);
        		listEstampDest = this.estampaRepository.findDestArtista(usuario, "S");
        	} 
        	else {
        		lstEntities = this.estampaRepository.findAll("A", "N");
        		listEstampDest = this.estampaRepository.findAll("A", "S");
        	}
    	}
    	else
    	{
    		lstEntities = this.estampaRepository.findAll("A", "N");		
    	}
    	List<EstampaDTO> estampasDest = new ArrayList<EstampaDTO>();
    	
    	
    	if (lstEntities != null) {
    		for (final Estampa estampa : lstEntities) {
    			estampas.add(new EstampaDTO(estampa));
    		}
    	}
    	
    	if (listEstampDest != null) {
    		for (final Estampa estampa : listEstampDest) {
    			estampasDest.add(new EstampaDTO(estampa));
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
    	model.addAttribute("estampasDest", estampasDest);
    	model.addAttribute("busqueda", busquedaCatalogo);
    	model.addAttribute("roluser", usuario.getRol());
    	model.addAttribute("suscripcion", usuario.getEstampasDestacar());
		
    	Long id_Tema= 1L;

		
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
		
		
		Long id_Tema= estampa.getTema().getIdTema();
				
		List <String> correosAll = this.userRepository.findByTema(id_Tema);
		for(int i=0;i<correosAll.size();i++){
		    System.out.println(i+" El ID del Tema es: "+id_Tema+" Y un Correo suscrito es: "+correosAll.get(i));
		} 
		SSLEmail mail = new SSLEmail(correosAll);
		mail.enviarTodos();

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
	
	/**
	 * Se encarga de eliminar la estampa
	 */
	
	@RequestMapping(value="/eliminaEstampa", method = RequestMethod.POST)
	public String eliminarEstampa(@RequestParam(value="es", required=true) Estampa es, Model model, final RedirectAttributes redirectAttributes){
		List<DetalleOrden> detalle = this.detalleOrdenRepository.findByEstampa(es);
		
		System.out.println("DetalleOrden: "+detalle.size());
		
		String Message;
		
		if(detalle.size() == 0)
		{
			this.estampaRepository.delete(es);
			Message = "La estampa ha sido eliminada con exito!";
		}
		else
		{
			Message = "La estampa tiene compras asociadas, no se puede eliminar!";
		}
		
		redirectAttributes.addFlashAttribute("errorDelete", Message);
		return "redirect:/catalogo";
	}
	

	@RequestMapping(value="/rechazarEstampa", method = RequestMethod.POST)
	public String rechazarEstampa(@RequestParam(value="es", required=true) Estampa es, Model model, final RedirectAttributes redirectAttributes){
		
		String Message;
		Message = "La estampa ha sido rechazada!";
		
		this.estampaRepository.updateEstado("I", es.getIdEstampa());
		
		
		redirectAttributes.addFlashAttribute("errorDelete", Message);
		return "redirect:/catalogo";
	}
	

	/**
	 * Se encarga de destacar/quitar destacado de la estampa
	 */
	
	@RequestMapping(value="/destacarEstampa", method = RequestMethod.POST)
	public String destacarEstampa(@RequestParam(value="idEst", required=true) Long idEst, Model model, final RedirectAttributes redirectAttributes){
		EstampasControllerVIP estampaVIP = new EstampasControllerVIP(userRepository, estampaRepository);
		return estampaVIP.destacarEstampaVIP(idEst, redirectAttributes);
	}
	
	public List<EstampaDTO> buscarEstampasByTema(Tema tema)
	{
		List<Estampa> buscaEstampas = this.estampaRepository.find(tema, "A", "N");
		List<EstampaDTO> estampas = this.estampas(buscaEstampas);
		return estampas;
	}
	
	public List<EstampaDTO> buscarEstampasByNombre(String nombre)
	{
		List<Estampa> buscaEstampas = this.estampaRepository.findByNombre(nombre, "A");
		List<EstampaDTO> estampas = this.estampas(buscaEstampas);
		
		return estampas;
	}
	
	public List<EstampaDTO> buscarEstampasByRating()
	{
		List<Estampa> buscaEstampas = this.estampaRepository.findByRating("A");
		List<EstampaDTO> estampas = this.estampas(buscaEstampas);
		
		return estampas;
	}
	
	public List<EstampaDTO> estampas(List<Estampa> estampasDTO)
	{
		List<EstampaDTO> estampas = new ArrayList<EstampaDTO>();
		
		if (estampasDTO != null) {
    		for (final Estampa estampa : estampasDTO) {
    			estampas.add(new EstampaDTO(estampa));
    		}
    	}
		
		return estampas;
	}
}
