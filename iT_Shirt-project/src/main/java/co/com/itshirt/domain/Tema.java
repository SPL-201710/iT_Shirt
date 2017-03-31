package co.com.itshirt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cata_tema")
public class Tema {
	
	@Id
	@GeneratedValue
	@Column(name = "tema_id")
	private Long idTema;
	
	@Column(name = "tema_nombre")
	private String nombre;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public Tema(Tema tema) {
		super();
		this.idTema = tema.idTema;
		this.nombre = tema.nombre;
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
