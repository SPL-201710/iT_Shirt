package co.com.itshirt.variability.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.com.itshirt.annotation.OptionalFeature;
import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.dto.EstampaDTO;
import co.com.itshirt.dto.variability.FiltrosCatalogoDTO;
import co.com.itshirt.repository.EstampaRepository;
import co.com.itshirt.repository.variability.EstampaAdvanceSearchRepository;


@OptionalFeature
@Controller
public class BusquedaAvanzada extends BusquedaCatalogo {
	
	private BusquedaConsultasRepository consultas;
	
	public BusquedaAvanzada() {
		this.tipoBusqueda = "Búsqueda Avanzada";
		this.busquedaAvanzada = true;
	}
	
	@Override
	public List<EstampaDTO> filtrarCatalogo(FiltrosCatalogoDTO filtros) {
		Tema tema = filtros.getTema(); 
		List<EstampaDTO> estampas = new ArrayList<EstampaDTO>();
		if(tema != null)
		{			
			estampas = this.filtroTema(tema);
			System.out.println(estampas);
			return estampas;
		}
		return null;
	}
	
	public List<EstampaDTO> filtroTema(Tema tema)
	{
		List<EstampaDTO> estampas = new ArrayList<EstampaDTO>();
		Iterable<Estampa> listaEstampa = null;
		
		listaEstampa = this.estampaRepository.find(tema, "A");
		
		
		if (listaEstampa != null) {
    		for (final Estampa estampa : listaEstampa) {
    			estampas.add(new EstampaDTO(estampa));
    		}
    	}
		return estampas;
	}




}