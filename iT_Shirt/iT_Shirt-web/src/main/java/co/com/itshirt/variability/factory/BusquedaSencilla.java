package co.com.itshirt.variability.factory;

import co.com.itshirt.dto.variability.IFiltrosCatalogoDTO;

public class BusquedaSencilla extends BusquedaCatalogo {
	
	public BusquedaSencilla() {
		this.tipoBusqueda = "Búsqueda Sencilla";
	}

	@Override
	public String filtrarCatalogo(IFiltrosCatalogoDTO filtros) {
		return "Resultado consulta sencilla";
	}

}