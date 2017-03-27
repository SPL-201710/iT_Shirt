package co.com.itshirt.controller;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.itshirt.domain.Tema;
import co.com.itshirt.repository.TemaRepository;

@Controller    // This means that this class is a Controller
public class TemaController {
	
	@Autowired
	private TemaRepository temaRepository;
	
	
	public @ResponseBody Iterable<Tema> getAllTemas() {
		// This returns a JSON or XML with the users
		return temaRepository.findAll();
	}
	
	@RequestMapping(value="/temas", method = RequestMethod.GET)
	public String temas()
	{
		final Iterable<Tema> temas = this.getAllTemas();
		Map<Long, String> mapTemas = new LinkedHashMap<Long, String>();
		System.out.println("Temas: "+temas);
		return "temas";
	}
	
	
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public String test()
	{
		return "test";
	}
}
