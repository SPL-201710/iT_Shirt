package co.com.itshirt.domain.vip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.com.itshirt.domain.OrdenCompra;

@Entity
@Table(name = "orde_detalleordenvip")
public class DetalleOrdenVIP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dvip_id")
	private Long idDetalle;
	
	@Column(name = "dvip_precio")
	private Long precio;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "orde_id")
    private OrdenCompra ordenCompra;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vip_id")
    private SuscripcionVIP suscripcion;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public DetalleOrdenVIP() {
		super();
	}

	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public SuscripcionVIP getSuscripcion() {
		return suscripcion;
	}

	public void setSuscripcion(SuscripcionVIP suscripcion) {
		this.suscripcion = suscripcion;
	}

}
