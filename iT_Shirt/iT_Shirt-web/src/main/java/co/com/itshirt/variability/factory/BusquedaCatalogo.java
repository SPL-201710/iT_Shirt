package co.com.itshirt.variability.factory;

import org.springframework.stereotype.Component;

import co.com.itshirt.dto.variability.IFiltrosCatalogoDTO;

@Component
public abstract class BusquedaCatalogo {
	
	protected String tipoBusqueda = "";
	protected boolean busquedaAvanzada = false;
	
	
	public abstract String filtrarCatalogo(IFiltrosCatalogoDTO filtros);

	public String getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(String tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

}
