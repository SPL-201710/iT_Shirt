package co.com.itshirt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.security.CustomUserDetails;

@Controller
public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserValidator userValidator;
	
	 @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	    public String welcome(Model model) {
	    	final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	if (!authentication.getName().equals("anonymousUser")) {
	    		CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		    	System.err.println("Usuario logueado: " +usuario.getNombres());
	    		return "welcome";
	    	} else {
	    		return "home";
	    	}
	    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Usuario());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult, Model model) {
//        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

//        userService.save(userForm);

//        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

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
