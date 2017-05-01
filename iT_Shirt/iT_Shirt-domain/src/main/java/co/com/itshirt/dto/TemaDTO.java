package co.com.itshirt.dto;

import co.com.itshirt.domain.Tema;

public class TemaDTO {
	
	private Long idTema;
	private String nombre;
	
	public TemaDTO()
	{
		
	}
	
	public TemaDTO(final Tema tema)
	{
		super();
		this.idTema = tema.getIdTema();
		this.nombre = tema.getNombre();
	}

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
