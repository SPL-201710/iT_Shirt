package co.com.itshirt.variability.delegation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.itshirt.controller.EstampasController;
import co.com.itshirt.domain.Estampa;
import co.com.itshirt.repository.EstampaRepository;
import co.com.itshirt.repository.TemaRepository;
import co.com.itshirt.repository.UserRepository;
import co.com.itshirt.security.CustomUserDetails;

@Controller
public class EstampasControllerVIP {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EstampaRepository estampaRepository;

	public EstampasControllerVIP(UserRepository userRepository, EstampaRepository estampaRepository) {
		super();
		this.userRepository = userRepository;
		this.estampaRepository = estampaRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public EstampaRepository getEstampaRepository() {
		return estampaRepository;
	}

	public void setEstampaRepository(EstampaRepository estampaRepository) {
		this.estampaRepository = estampaRepository;
	}

	public String destacarEstampaVIP(Long idEst, final RedirectAttributes redirectAttributes){
		final Estampa estampa = this.estampaRepository.findOne(idEst);
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final CustomUserDetails usuario = (CustomUserDetails) authentication.getPrincipal();
		
		String Message;
		if(estampa.getDestacada().equals("N"))
		{
			if (usuario.getEstampasDestacar() != null){
				if (usuario.getEstampasDestacar() > 0){
					this.estampaRepository.updateDestacada("S", estampa.getIdEstampa());
					this.userRepository.updateSuscripVIPEstampas(-1, usuario.getIdUsuario());
					Message = "La estampa es destacada desde ahora";
				}
				else
					Message = "Ya no puede destacar mas estampas. "
							+ "Para destacar otra estampa, compre otro paquete VIP o quite el destacado a una estampa";
			}
			else 
				Message = "Debe comprar un paquete VIP para destacar la estampa";
		}
		else
		{
			this.estampaRepository.updateDestacada("N", estampa.getIdEstampa());
			this.userRepository.updateSuscripVIPEstampas(1, usuario.getIdUsuario());
			Message = "La estampa ya no es destacada";
		}

		redirectAttributes.addFlashAttribute("errorDelete", Message);
		return "redirect:/catalogo";
	}
	
	public String calificarEstampaVIP(Long idOrden, Long idEst, String calificacion, final RedirectAttributes redirectAttributes){
		String Mensaje;
		if (calificacion.equals(""))
			Mensaje = "Estampa no calificada. Debe seleccionar el número de estrellas (1 a 5)";
		else
		{
			final Estampa estampa = this.estampaRepository.findOne(idEst);
			float SumaRating = (estampa.getRating() * (float) estampa.getCalificada()) + Float.valueOf(calificacion);
			System.out.print(SumaRating);
			System.out.print("\n");
			float ratingFinal = SumaRating / (float) (estampa.getCalificada() + 1);
			System.out.print(ratingFinal);
			System.out.print("\n");
			this.estampaRepository.updateRating(ratingFinal, idEst);
			this.estampaRepository.updateCalificada(idEst);
			Mensaje = "Estampa calificada exitosamente";
		}	
		redirectAttributes.addFlashAttribute("MsgCalificar", Mensaje);
		return "redirect:/compras/detalle/?es="+String.valueOf(idOrden);
	}
	
}
