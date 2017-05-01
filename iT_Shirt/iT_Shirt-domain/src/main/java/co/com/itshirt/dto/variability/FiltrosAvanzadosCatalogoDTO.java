package co.com.itshirt.dto.variability;

public class FiltrosAvanzadosCatalogoDTO extends FiltrosCatalogoDTO implements IFiltrosCatalogoDTO {
	
	private String autor;
	private String tema;
	
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

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
