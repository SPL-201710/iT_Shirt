package co.com.itshirt.domain.vip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.com.itshirt.enums.EnumEstado;

/**
 * Entidad Suscripciones VIP.
 * @author ja.picon
 *
 */
@Entity
@Table(name = "vip_suscripcionvip")
public class SuscripcionVIP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vip_id")
	private Long idSuscripcion;
	
	@Column(name = "vip_precio")
	private Long precio;
	
	@Column(name = "vip_descripcion")
	private String descripcion;
	
	@Column(name = "vip_cantidadestampas")
	private Long cantidad;
	
	@Column(name = "vip_estado")
	private String estado;
	
	public SuscripcionVIP() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdSuscripcion() {
		return idSuscripcion;
	}

	public void setIdSuscripcion(Long idSuscripcion) {
		this.idSuscripcion = idSuscripcion;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstadoDesc() {
		return EnumEstado.get(this.estado).getNombre();
	}
	
}
