package co.com.itshirt.variability.factory;

import co.com.itshirt.annotation.OptionalFeature;
import co.com.itshirt.dto.variability.IFiltrosCatalogoDTO;

@OptionalFeature
public class BusquedaAvanzada extends BusquedaCatalogo {

	public BusquedaAvanzada() {
		this.tipoBusqueda = "Búsqueda Avanzada";
		this.busquedaAvanzada = true;
	}
	
	@Override
	public String filtrarCatalogo(IFiltrosCatalogoDTO filtros) {
		return "Resultado consulta avanzada";
	}

}