package co.com.itshirt.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
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

import co.com.itshirt.domain.Tema;
import co.com.itshirt.domain.Usuario;
import co.com.itshirt.domain.UsuarioTema;
import co.com.itshirt.dto.CambioCredencialesDTO;
import co.com.itshirt.dto.PerfilUsuarioDTO;
import co.com.itshirt.dto.TemaDTO;
import co.com.itshirt.dto.UsuarioTemaDTO;
import co.com.itshirt.enums.EnumSexo;
import co.com.itshirt.repository.TemaRepository;
import co.com.itshirt.repository.UserRepository;
import co.com.itshirt.repository.UsuarioTemaRepository;
import co.com.itshirt.repository.service.SecurityService;
import co.com.itshirt.security.CustomUserDetails;

/**
 * Controlador perfil de usuario.
 * @author ja.picon
 * @since 29/03/2017
 *
 */
@Controller
public class PerfilUsuarioController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private UsuarioTemaRepository usuarioTemaRepository;
	@Autowired
	private TemaRepository temaRepository;
	
	/**
	 * Método inicial del controlador.
	 */
	@PostConstruct
	public void init() {
		
	}

	/**
	 * Cargando página perfil usuario.
	 * @return Nombre de la página a redireccionar.
	 */
	@RequestMapping(value ="/perfil", method = RequestMethod.GET)
	public String actualizarPerfil(ModelMap model, HttpSession session, HttpServletRequest request) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
    	final Map<String,String> mapSexos = new LinkedHashMap<String,String>();
    	
		for (EnumSexo sexo : EnumSexo.ENUM_VALUES) {
			mapSexos.put(sexo.getCodigo(), sexo.getDescripcion());
		}    	

    	model.addAttribute("perfilForm", new PerfilUsuarioDTO(usuario));
    	model.addAttribute("usuarioTema", new UsuarioTemaDTO());
    	model.addAttribute("sexos", mapSexos);
    	model.addAttribute("temas", this.temasUsuario());
    	model.addAttribute("selecttemas", this.temas());
		return "perfil/perfil";
	}
	
	/**
	 * Método llamado al momento de guardar el formulario de creación.
	 */
	@RequestMapping(value = "/perfil", method = RequestMethod.POST)
	public String checkActualizarPerfil(@Valid PerfilUsuarioDTO perfilForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("perfilForm", perfilForm);
			return "perfil/perfil";
		}
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		final Usuario usuario = this.userRepository.findOne(customUserDetails.getIdUsuario());
		usuario.setNombres(perfilForm.getNombres());
		usuario.setApellidos(perfilForm.getApellidos());
		usuario.setEmail(perfilForm.getEmail());
		usuario.setGenero(perfilForm.getGenero());
		usuario.setTelefono(perfilForm.getTelefono());
		this.userRepository.save(usuario);
		model.addAttribute("msgExitoso", "Se han actualizado sus datos exitosamente.");
		this.securityService.autologin(usuario.getUsername(), usuario.getPassword());
		return "redirect:/welcome";
	}
	
	@RequestMapping(value ="/perfil/cambiarCredenciales", method = RequestMethod.GET)
	public String cambiarCredenciales(ModelMap model, HttpSession session, HttpServletRequest request) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
    	model.addAttribute("credencialesForm", new CambioCredencialesDTO());
		return "perfil/cambiarCredenciales";
	}
	
	/**
	 * Método llamado al momento de guardar el formulario de creación.
	 */
	@RequestMapping(value = "/perfil/cambiarCredenciales", method = RequestMethod.POST)
	public String checkCambiarPerfil(@Valid CambioCredencialesDTO credencialesForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("credencialesForm", credencialesForm);
		}
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		if (!usuario.getPassword().equals(credencialesForm.getActualPassword())) {
        	model.addAttribute("error", "Contraseña actual invalida. Por favor, verifique e intente nuevamente.");
        	model.addAttribute("credencialesForm", credencialesForm);
        } else {
        	final Usuario user = this.userRepository.findOne(usuario.getIdUsuario());
        	user.setPassword(credencialesForm.getNewPassword());
        	this.userRepository.save(user);
        	model.addAttribute("credencialesForm", new CambioCredencialesDTO());
    		model.addAttribute("msgExitoso", "Se han actualizado sus datos exitosamente.");
        }
		return "perfil/cambiarCredenciales";
	}
	
	@RequestMapping(value = "temasFavoritos", method = RequestMethod.GET)
	public String TemasFavoritos(ModelMap model, HttpSession session, HttpServletRequest request){
		
		model.addAttribute("selecttemas", this.temas());
		model.addAttribute("usuarioTema", new UsuarioTemaDTO());
		model.addAttribute("temas", this.temasUsuario());
		
		return "perfil/temasFavoritos";
	}
	
	@RequestMapping(value = "temasFavoritos", method = RequestMethod.POST)
	public String crearTemasFavoritos(@Valid UsuarioTemaDTO usuarioTema, BindingResult bindingResult, Model model, HttpServletRequest request){
		final UsuarioTema usuTema = new UsuarioTema();
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		final Usuario usuario = this.userRepository.findOne(customUserDetails.getIdUsuario());
		
		usuTema.setTema(this.temaRepository.findOne(usuarioTema.getTema()));
		usuTema.setUsuario(usuario);
		
		this.usuarioTemaRepository.save(usuTema);
		
		model.addAttribute("selecttemas", this.temas());
		model.addAttribute("usuarioTema", new UsuarioTemaDTO());
		model.addAttribute("temas", this.temasUsuario());
		return "perfil/temasFavoritos";
	}
	
	private Map<Long, String> temas()
	{
		final Iterable<Tema> temas = this.temaRepository.findAll();
		final Map<Long, String> mapTemas = new LinkedHashMap<Long, String>();
		
		for (Tema tema : temas){
			mapTemas.put(tema.getIdTema(), tema.getNombre());
			System.out.println(tema.getIdTema() + " " + tema.getNombre());
		}
		
		return mapTemas;
	}
	
	private List<TemaDTO> temasUsuario(){
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
    	final List<UsuarioTema> temasUsuario = this.usuarioTemaRepository.findByUsuario(usuario);
    	final List<TemaDTO> temaUsuario = new ArrayList<TemaDTO>();
    	
    	for(final UsuarioTema tema : temasUsuario)
    	{
    		temaUsuario.add(new TemaDTO(tema.getTema()));
    	}
    	
    	return temaUsuario;
	}
	
	
}