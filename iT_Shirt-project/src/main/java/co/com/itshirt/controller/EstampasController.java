package co.com.itshirt.controller;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.EstampaRepository;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.domain.TemaRepository;
import co.com.itshirt.dto.CreacionEstampaDTO;
import co.com.itshirt.enums.EnumEstadoEstampa;
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
	
	@RequestMapping(value="catalogo", method = RequestMethod.GET)
	public String verEstampas(ModelMap model, HttpSession session)
	{
		return "catalogo";
	}
	
	/**
	 * Se encarga de cargar la pagina de creación de estampas.
	 */
	@RequestMapping(value="/crearEstampa", method = RequestMethod.GET)
	public String addEstampa(ModelMap model, HttpSession session) {
		final Iterable<Tema> temas = this.temaRepository.findAll();
		Map<Long,String> mapTemas = new LinkedHashMap<Long,String>(); //Para leerlo de <form:options> toca así.
		System.err.println("temas: " +temas);
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
	public String checkCrearEstampa(@Valid CreacionEstampaDTO creaEst, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			System.err.println(bindingResult.getFieldErrors());
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("estampaForm", creaEst);
			return "estampa/creacionEstampa";
		}
		System.err.println(creaEst.getFile().getOriginalFilename());
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		Estampa estampaNueva = new Estampa();
		estampaNueva.setArtista(usuario);
		estampaNueva.setDescripcion(creaEst.getDescripcion());
		estampaNueva.setEstado(EnumEstadoEstampa.ACTIVA.getCodigo());
		estampaNueva.setEstaNombreCorto(creaEst.getEstaNombreCorto());
		estampaNueva.setPrecio(creaEst.getPrecio());
		estampaNueva.setTema(this.temaRepository.findOne(creaEst.getIdTema()));
		estampaNueva.setUrl(creaEst.getFile().getOriginalFilename());
		estampaNueva = this.estampaRepository.save(estampaNueva); //Para recuperar el ID
		FileUtils.guardarArchivoEstampa(creaEst.getFile(), usuario.getIdUsuario(), estampaNueva.getIdEstampa(), request);
//		estampaNueva.setUrl(url);
//		this.estampaRepository.save(estampaNueva);
		return "redirect:/catalogo";
	}
	
}
