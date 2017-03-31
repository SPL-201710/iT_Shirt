package co.com.itshirt.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.domain.Artista;
import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.Rol;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.dto.CreacionEstampaDTO;
import co.com.itshirt.dto.UsuarioDTO;
import co.com.itshirt.enums.EnumEstadoEstampa;
import co.com.itshirt.enums.EnumRol;
import co.com.itshirt.security.CustomUserDetails;
import co.com.itshirt.util.FileUtils;
import co.com.itshirt.repository.UserRepository;
import co.com.itshirt.repository.RolRepository;

@Controller
public class ArtistaController {
	
	private UserRepository userRepository;
	private RolRepository rolRepository;
	
	/**
	 * Ver todos los artistas.
	 */
	
	@RequestMapping(value="artistas", method = RequestMethod.GET)
	public String verArtistas(ModelMap model, HttpSession session)
	{
		/*final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();*/
    	Iterable<Usuario> listEntities = null;
    	List<UsuarioDTO> artistas = new ArrayList<UsuarioDTO>();
    	Rol ArtistaRol = this.rolRepository.findBySigla("ARTIS");
    	listEntities = this.userRepository.findByRol(ArtistaRol);
    	
    	if (listEntities != null) {
    		for (final Usuario artista : listEntities) {
    			artistas.add(new UsuarioDTO(artista));
    		}
    	}
    	model.addAttribute("artistas", artistas);
    	System.out.println("rol " + ArtistaRol);
		return "artistas";
	}
	/**
	 * Se encarga de cargar la pagina de creación de artista.
	 */	
	@RequestMapping(value="/crearEstampa", method = RequestMethod.GET)
	public String addArtista(ModelMap model, HttpSession session)
	{
		final Iterable<Rol> roles = this.rolRepository.findAll();
		Map<Long,String> mapRoles = new LinkedHashMap<Long,String>(); //Para leerlo de <form:options> toca así.
		for (Rol rol : roles) {
			mapRoles.put(rol.getIdRol(), rol.getNombre());
		}
		model.addAttribute("roles", mapRoles);
		model.addAttribute("artistaForm", new UsuarioDTO());
		return "artista/creacionArtista";
	}
	
	/**
	 * Método llamado al momento de guardar el formulario de creación.
	 */
	@RequestMapping(value = "/crearArtista", method = RequestMethod.POST)
	public String CrearArtista(@Valid UsuarioDTO artista, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("artistaForm", artista);
			return "artista/creacionArtista";
		}
		/*final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();*/
    	Usuario artistaNuevo = new Usuario();
		artistaNuevo.setIdUsuario(artista.getIdUsuario());
		artistaNuevo.setUsername(artista.getUsername());
		artistaNuevo.setPassword(artista. getPassword());
		artistaNuevo.setNombres(artista.getNombres());
		artistaNuevo.setApellidos(artista.getApellidos());
		artistaNuevo.setEmail(artista.getEmail());
		artistaNuevo.setTelefono(artista.getTelefono());
		artistaNuevo.setRol(artista.getRol());
		artistaNuevo.setPasswordConfirm(artista.getPasswordConfirm());
		artistaNuevo = this.userRepository.save(artistaNuevo); //Para recuperar el ID
		return "redirect:/artistas";
	}
}
