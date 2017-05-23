package co.com.itshirt.dto.variability;

import co.com.itshirt.domain.Tema;

public class FiltrosAvanzadosCatalogoDTO extends FiltrosCatalogoDTO implements IFiltrosCatalogoDTO {
	
	private String autor;
	private Tema tema;
	
	public FiltrosAvanzadosCatalogoDTO() {
		super();
		super.filtrosBasicos = false;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
