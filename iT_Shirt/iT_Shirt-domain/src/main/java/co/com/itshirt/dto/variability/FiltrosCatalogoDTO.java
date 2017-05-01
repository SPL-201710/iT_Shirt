package co.com.itshirt.dto.variability;

public class FiltrosCatalogoDTO implements IFiltrosCatalogoDTO {
	
	private String autor;
	private String tema;
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

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public boolean isFiltrosBasicos() {
		return filtrosBasicos;
	}

	public void setFiltrosBasicos(boolean filtrosBasicos) {
		this.filtrosBasicos = filtrosBasicos;
	}

}
