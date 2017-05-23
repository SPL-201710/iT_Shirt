package co.com.itshirt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador Rest Usuarios.
 * @author ja.picon
 */
@RestController
@RequestMapping("/rest")
public class ProfileRestController {
	
	@RequestMapping("/profile")
    public String getUsuarios() {
        return "Great :D";
    }
	
    
}
