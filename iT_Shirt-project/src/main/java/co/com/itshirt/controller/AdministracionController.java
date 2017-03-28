package co.com.itshirt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.dto.CreacionEstampaDTO;
import co.com.itshirt.enums.EnumEstadoEstampa;
import co.com.itshirt.repository.TemaRepository;
import co.com.itshirt.security.CustomUserDetails;
import co.com.itshirt.util.FileUtils;


@Controller
@RequestMapping("/admin")
public class AdministracionController {
	
	@Autowired
	private TemaRepository temaRepository;
	
	@RequestMapping(value="usuarios", method = RequestMethod.GET)
	public String usuarios(ModelMap model, HttpSession session) {
		return "usuario/listadoUsuarios";
	}
	
	@RequestMapping(value="temas", method = RequestMethod.GET)
	public String temas(ModelMap model, HttpSession session) {
		model.addAttribute("temas", this.temaRepository.findAll());
		model.addAttribute("temaForm", new Tema());
		return "tema/listadoTemas";
	}
	
	/**
	 * Método llamado al momento de guardar el formulario de creación.
	 */
	@RequestMapping(value = "/temas", method = RequestMethod.POST)
	public String checkCrearTema(@Valid Tema tema, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Por favor, llene los campos obligatorios.");
			model.addAttribute("temaForm", tema);
			
		}
		this.temaRepository.save(tema);
		model.addAttribute("temaForm", new Tema());
		model.addAttribute("temas", this.temaRepository.findAll());
		return "tema/listadoTemas";
	}
	
	@RequestMapping(value="estampas", method = RequestMethod.GET)
	public String estampas(ModelMap model, HttpSession session) {
		return "redirect:/catalogo";
	}
	
}
