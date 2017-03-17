package co.com.itshirt.admin.controller.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.itshirt.service.UsuarioServicio;

//import co.com.itshirt.api.dto.EjemploDTO;

@Controller
@RequestMapping("/example")
public class EjemploController {
	

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@PostConstruct
	 public void init(){
		//this.usuarioServicio = new UsuarioServicio();
				System.out.println(this.usuarioServicio.consultaEjemplo());
				System.out.println("Ingreso ejemplo controller");
	 }
	 
	 @PreDestroy
	 public void despedirse(){
	   System.out.println("Adios");
	 }
	
	/**
	 * Método inicial /
	 * @param model
	 * @return
	 */
//	@RequestMapping(method = RequestMethod.GET)
//	public String printHello(ModelMap model) {
//		this.objeto = new EjemploDTO("Esto es una prueba!");
//		model.addAttribute("objeto", this.objeto);
//	    return "/example/example";
//   }
	
	@RequestMapping(value = "/tabla", method = RequestMethod.GET)
	public String mostrarTabla(ModelMap model) {
//		this.datos = this.ejemploBean.obtenerDatos();
//		model.addAttribute("datos", this.datos);
	    return "/example/table";
	}

//	public EjemploDTO getObjeto() {
//		return objeto;
//	}
//
//	public void setObjeto(EjemploDTO objeto) {
//		this.objeto = objeto;
//	}
	
}
