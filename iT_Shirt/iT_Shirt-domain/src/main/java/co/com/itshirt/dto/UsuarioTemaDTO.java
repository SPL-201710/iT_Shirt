package co.com.itshirt.dto;

import co.com.itshirt.domain.UsuarioTema;

public class UsuarioTemaDTO {
	
	private Long idUsuarioTema;
	private Long usuario;
	private Long tema;
	
	public UsuarioTemaDTO(final UsuarioTema usuariotema){
		super();
		this.idUsuarioTema = usuariotema.getIdUsuarioTema();
		this.usuario = usuariotema.getUsuario().getIdUsuario();
		this.tema = usuariotema.getTema().getIdTema();
	}
	
	public Long getTema() {
		return tema;
	}
	public void setTema(Long tema) {
		this.tema = tema;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public Long getIdUsuarioTema() {
		return idUsuarioTema;
	}
	public void setIdUsuarioTema(Long idUsuarioTema) {
		this.idUsuarioTema = idUsuarioTema;
	}
}
