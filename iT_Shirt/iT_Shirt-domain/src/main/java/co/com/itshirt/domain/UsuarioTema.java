package co.com.itshirt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usua_tema")
public class UsuarioTema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idusua_tema")
	private Long idUsuarioTema;
	
	@Column(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "tema_id")
	private Tema tema;
	
	public Long getIdUsuarioTema() {
		return idUsuarioTema;
	}

	public void setIdUsuarioTema(Long idUsuarioTema) {
		this.idUsuarioTema = idUsuarioTema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
}
