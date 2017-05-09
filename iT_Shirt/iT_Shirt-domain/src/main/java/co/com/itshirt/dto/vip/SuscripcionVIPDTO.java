package co.com.itshirt.dto.vip;

import javax.persistence.Column;

import co.com.itshirt.domain.vip.SuscripcionVIP;

/**
 * DTO Suscripciones VIP.
 * @author ja.picon
 *
 */
public class SuscripcionVIPDTO {
	
	private Long idSuscripcion;
	private Long precio;
	private String descripcion;
	private Long cantidad;
	private String estado;
	
	public SuscripcionVIPDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SuscripcionVIPDTO(SuscripcionVIP entity) {
		this.idSuscripcion = entity.getIdSuscripcion();
		this.precio = entity.getPrecio();
		this.descripcion = entity.getDescripcion();
		this.cantidad = entity.getCantidad();
		this.estado = entity.getEstado();
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
	
}
