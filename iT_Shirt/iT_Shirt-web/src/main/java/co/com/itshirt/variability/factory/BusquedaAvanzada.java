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


@OptionalFeature
@Controller
public class BusquedaAvanzada extends BusquedaCatalogo {
	
	
	public BusquedaAvanzada() {
		this.tipoBusqueda = "Búsqueda Avanzada";
		this.busquedaAvanzada = true;
	}

	@Override
	public List<EstampaDTO> filtrarCatalogo(FiltrosCatalogoDTO filtros) {
		// TODO Auto-generated method stub
		return null;
	}





}