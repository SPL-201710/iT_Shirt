package co.com.itshirt.variability.factory;

import java.util.List;

import co.com.itshirt.dto.EstampaDTO;
import co.com.itshirt.dto.variability.FiltrosCatalogoDTO;

public class BusquedaSencilla extends BusquedaCatalogo {
	
	public BusquedaSencilla() {
		this.tipoBusqueda = "Búsqueda Sencilla";
	}

	@Override
	public List<EstampaDTO> filtrarCatalogo(FiltrosCatalogoDTO filtros) {
		return null;
	}

}