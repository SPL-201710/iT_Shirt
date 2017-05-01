package co.com.itshirt.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.repository.UserRepository;

/**
 * Controlador Rest Usuarios.
 * @author ja.picon
 */
@RestController("/rest")
public class UsuarioRestController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) this.userRepository.findAll();
    }
    
}
