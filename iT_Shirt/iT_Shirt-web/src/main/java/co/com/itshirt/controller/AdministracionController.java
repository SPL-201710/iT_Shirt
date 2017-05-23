package co.com.itshirt.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.domain.Usuario;
import co.com.itshirt.repository.EstampaRepository;
import co.com.itshirt.repository.TemaRepository;
import co.com.itshirt.repository.UserRepository;


@Controller
@RequestMapping("/admin")
public class AdministracionController {
	
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EstampaRepository estampaRepository;
	
	@RequestMapping(value="usuarios", method = RequestMethod.GET)
	public String usuarios(ModelMap model, HttpSession session) {
		model.addAttribute("usuarios", this.userRepository.findAll());
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
	
	@RequestMapping(value="/cambioestado", method = RequestMethod.GET)
	public String cambioEstado(@RequestParam(value="id", required=false) Usuario user, Model model, HttpServletRequest request){
		
		if(user.getEstado().equals("A"))
		{
			//usuario.setEstado("I");
			this.userRepository.updateEstado("I", user.getIdUsuario());
		}
		else
		{
			//usuario.setEstado("A");
			this.userRepository.updateEstado("A", user.getIdUsuario());
		}
		
		return "redirect:usuarios";
	}
	
	@RequestMapping(value="/eliminarTema", method = RequestMethod.POST)
	public String eliminarTema(@RequestParam(value="id", required=false) Tema tema, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes){
		
		List<Estampa> estampas = this.estampaRepository.findByTema(tema);
		String Message;
		if(estampas.size() == 0)
		{
			this.temaRepository.delete(tema);
			Message = "El tema se ha eliminado correctamente";
		}
		else
		{
			Message = "El tema tiene estampas relacionadas, no se ha podido eliminar!";
		}
		
		redirectAttributes.addFlashAttribute("errorDelete", Message);
		return "redirect:temas";
	}
	
	@RequestMapping(value="/editarTema", method = RequestMethod.POST)
	public String editarTema(@RequestParam(value="id", required=false) Tema tema, @RequestParam(value="nameTema", required=false) String nameTema,
	Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes){
		String Message = null;
		tema.setNombre(nameTema);
		this.temaRepository.save(tema);
		Message = "El tema se ha editado correctamente";
		redirectAttributes.addFlashAttribute("errorDelete", Message);
		return "redirect:temas";
	}

}
