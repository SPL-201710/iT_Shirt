package co.com.itshirt.controller;

import java.util.LinkedHashMap;
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

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.dto.PerfilUsuarioDTO;
import co.com.itshirt.enums.EnumSexo;
import co.com.itshirt.repository.UserRepository;
import co.com.itshirt.security.CustomUserDetails;
import co.com.itshirt.service.SecurityService;

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
    	model.addAttribute("sexos", mapSexos);
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
		return "perfil/cambiarCredenciales";
	}
	
	
}