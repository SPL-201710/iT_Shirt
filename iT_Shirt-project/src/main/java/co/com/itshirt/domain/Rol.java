package co.com.itshirt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usua_rol")
public class Rol {
	
	@Id
	@GeneratedValue
	@Column(name = "rol_id")
	private Long idRol;
	
	@Column(name = "rol_nombre")
	private String nombre;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public Rol() {
		super();
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
