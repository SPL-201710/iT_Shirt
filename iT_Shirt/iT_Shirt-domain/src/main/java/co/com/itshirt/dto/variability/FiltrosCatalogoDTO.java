package co.com.itshirt.dto.variability;

import co.com.itshirt.domain.Tema;

public class FiltrosCatalogoDTO implements IFiltrosCatalogoDTO {
	
	private String autor;
	private Tema tema;
	protected boolean filtrosBasicos = true;
	
	public FiltrosCatalogoDTO() {
		super();
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

	public boolean isFiltrosBasicos() {
		return filtrosBasicos;
	}

	public void setFiltrosBasicos(boolean filtrosBasicos) {
		this.filtrosBasicos = filtrosBasicos;
	}


}
