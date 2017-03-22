package co.com.itshirt.autenticacion.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class AutenticacionRestController {
	
//	@Autowired
//    OAuth2RestTemplate oauthRestTemplate;
	
	@RequestMapping(value = "/autenticacion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerAutenticacion(HttpSession session) {
//		OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder
//	            .getContext()
//	            .getAuthentication();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
	
}
