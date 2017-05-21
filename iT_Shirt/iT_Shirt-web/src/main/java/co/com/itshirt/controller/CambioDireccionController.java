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
import co.com.itshirt.dto.variability.perfil.CambioDireccionDTO;
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
public class CambioDireccionController {
	
	@Autowired
	private UserRepository userRepository;
	
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
	@RequestMapping(value ="/perfil/cambiarDireccion", method = RequestMethod.GET)
	public String actualizarPerfil(ModelMap model, HttpSession session, HttpServletRequest request) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
    	model.addAttribute("cambioDireccionForm", new CambioDireccionDTO(usuario.getIdUsuario(), usuario.getDireccion()));
		return "perfil/cambiarDireccion";
	}
	
	/**
	 * Método llamado al momento de guardar el formulario de creación.
	 */
	@RequestMapping(value = "/perfil/cambiarDireccion", method = RequestMethod.POST)
	public String checkActualizarPerfil(@Valid CambioDireccionDTO cambioDireccionForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("cambioDireccionForm", cambioDireccionForm);
			return "perfil/cambiarDireccion";
		}
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		this.userRepository.actualizarDireccion(cambioDireccionForm.getDireccion(), cambioDireccionForm.getIdUsuario());
		usuario.setDireccion(cambioDireccionForm.getDireccion());
		model.addAttribute("cambioDireccionForm", new CambioDireccionDTO(usuario.getIdUsuario(), usuario.getDireccion()));
		model.addAttribute("msgExitoso", "Se han actualizado sus datos exitosamente.");
		return "perfil/cambiarDireccion";
	}
	
	
}