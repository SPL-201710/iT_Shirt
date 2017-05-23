package co.com.itshirt.variability.factory;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.itshirt.dto.EstampaDTO;
import co.com.itshirt.dto.variability.FiltrosCatalogoDTO;
import co.com.itshirt.repository.variability.EstampaAdvanceSearchRepository;

@Component
public abstract class BusquedaCatalogo {
	
	protected String tipoBusqueda = "";
	protected boolean busquedaAvanzada = false;
	@Autowired
	protected EstampaAdvanceSearchRepository estampaRepository;
	
	
	public abstract List<EstampaDTO> filtrarCatalogo(FiltrosCatalogoDTO filtros);

	public String getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(String tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

}
