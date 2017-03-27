package co.com.itshirt.autenticacion.controller;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import co.com.itshirt.api.util.StringUtils;

@RestController
public class TemaController {
	
	@RequestMapping("/temas")
	public List<Tema> temas()
	{
		return Json.createArrayBuilder()
				.add(tema("Animales",1))
				.add(tema("Deportes",2))
				.add(tema("Música",3))
				.build();
	}
	
	public JsonObject tema(String name, int id)
	{
		return Json.createObjectBuilder()
				.add("name", name)
				.add("id", id)
				.build();
	}
}
