package co.com.itshirt.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orde_orden")
public class OrdenCompra {
	
	@Id
	@GeneratedValue
	@Column(name = "orde_id")
	private Long idOrdenCompra;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "orde_fecha", insertable = true, updatable = true, nullable = false)
	private Date fecha;
	
	@Column(name = "orde_estado")
	private String estado;
	
	@Column(name = "orde_direccionEnvio")
	private String direccionEnvio;
	
	@Column(name = "orde_telefonocontacto")
	private String telefonoContacto;
	
	@Column(name = "usua_id")
	private String idUsuario;
	
	@Column(name = "orde_total")
	private Long total;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public OrdenCompra() {
		super();
	}

	public Long getIdOrdenCompra() {
		return idOrdenCompra;
	}

	public void setIdOrdenCompra(Long idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
}
