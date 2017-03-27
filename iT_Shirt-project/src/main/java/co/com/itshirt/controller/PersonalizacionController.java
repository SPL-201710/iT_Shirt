package co.com.itshirt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.com.itshirt.repository.PersonalizacionRepository;

@Controller
public class PersonalizacionController {
	
	@Autowired
	private PersonalizacionRepository personalizacionRepository;
	
	
}
