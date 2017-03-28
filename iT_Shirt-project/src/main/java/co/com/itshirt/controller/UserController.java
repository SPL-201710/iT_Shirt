package co.com.itshirt.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.dto.RegistroUsuarioDTO;
import co.com.itshirt.enums.EnumRol;
import co.com.itshirt.enums.EnumSexo;
import co.com.itshirt.repository.RolRepository;
import co.com.itshirt.repository.UserRepository;
import co.com.itshirt.service.SecurityService;

/**
 * Controlador funcionalidades usuarios.
 * @author ja.picon
 */
@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RolRepository rolRepository;
	@Autowired
	private SecurityService securityService;

	/**
     * Crear cuenta de usuario.
     */
    @RequestMapping(value = "/crearCuenta", method = RequestMethod.GET)
    public String crearCuenta(Model model) {
    	Map<String,String> mapRoles = new LinkedHashMap<String,String>(); //Para leerlo de <form:options> toca así.
    	Map<String,String> mapSexos = new LinkedHashMap<String,String>(); 
		for (EnumRol rol : EnumRol.obtenerRolesPermitenRegistro()) {
			mapRoles.put(rol.getSigla(), rol.getNombre());
		}
		for (EnumSexo sexo : EnumSexo.ENUM_VALUES) {
			mapSexos.put(sexo.getCodigo(), sexo.getDescripcion());
		}
    	model.addAttribute("userForm", new RegistroUsuarioDTO());
    	model.addAttribute("roles", mapRoles);
    	model.addAttribute("sexos", mapSexos);
        return "registration";
    }

    @RequestMapping(value = "/crearCuenta", method = RequestMethod.POST)
    public String crearCuenta(@ModelAttribute("userForm") RegistroUsuarioDTO userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("userForm", userForm);
            return "registration";
        }
        if (this.userRepository.findByUsername(userForm.getUsername()) != null) {
        	model.addAttribute("error", "Ya existe en el sistema un usuario con el nombre mencionado. Por favor, verifique e intente nuevamente..");
			model.addAttribute("userForm", userForm);
            return "registration";
        }
        final Usuario usuario = new Usuario(); //TODO Mejorar: Pasar a un servicio toda esta lógica.
        usuario.setUsername(userForm.getUsername());
        usuario.setPassword(userForm.getPassword());
        usuario.setNombres(userForm.getNombres());
        usuario.setApellidos(userForm.getApellidos());
        usuario.setTelefono(userForm.getTelefono());
        usuario.setEmail(userForm.getEmail());
        usuario.setGenero(userForm.getSexo());
        usuario.setRol(this.rolRepository.findBySigla(userForm.getRolUsuario()));
        this.userRepository.save(usuario);
        this.securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/welcome";
    }

    /**
     * Manejo petición login de usuarios.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
        	model.addAttribute("error", "Usuario y contraseña invalida.");
        }
        if (logout != null) {
        	model.addAttribute("message", "Ha salido del sistema satisfactoriamente.");
        }
        return "login";
    }

}
