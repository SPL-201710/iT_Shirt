package co.com.itshirt.controller;


import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import antlr.collections.List;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.repository.TemaRepository;

@Controller
public class TemaController {
	
	private TemaRepository temaRepository;
	
	@RequestMapping(value="temas", method = RequestMethod.GET)
	public @ResponseBody Iterable<Tema> getAllTemas() {
		// This returns a JSON or XML with the users
		return temaRepository.findAll();
	}
	
	public JsonObject tema(String name, int id)
	{
		return Json.createObjectBuilder()
				.add("name", name)
				.add("id", id)
				.build();
	}
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public String test()
	{
		return "test";
	}
}
