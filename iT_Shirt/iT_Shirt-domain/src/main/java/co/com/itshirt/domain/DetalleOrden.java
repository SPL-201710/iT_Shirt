package co.com.itshirt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orde_detalleorden")
public class DetalleOrden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deto_id")
	private Long idDetalle;
	
	@Column(name = "deto_talla")
	private String talla;
	
	@Column(name = "deto_color")
	private String color;
	
	@Column(name = "deto_cantidad")
	private Long cantidad;
	
	@Column(name = "deto_textoconfigurado")
	private String textoConfigurado;
	
	@Column(name = "deto_preciocamiseta")
	private Long precioCamiseta;
	
	@Column(name = "deto_precioestampa")
	private Long precioEstampa;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "orde_id")
    private OrdenCompra ordenCompra;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "esti_id")
    private EstiloCamiseta estiloCamiseta;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "esta_id")
    private Estampa estampa;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public DetalleOrden() {
		super();
	}

	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTextoConfigurado() {
		return textoConfigurado;
	}

	public void setTextoConfigurado(String textoConfigurado) {
		this.textoConfigurado = textoConfigurado;
	}

	public Long getPrecioCamiseta() {
		return precioCamiseta;
	}

	public void setPrecioCamiseta(Long precioCamiseta) {
		this.precioCamiseta = precioCamiseta;
	}

	public Long getPrecioEstampa() {
		return precioEstampa;
	}

	public void setPrecioEstampa(Long precioEstampa) {
		this.precioEstampa = precioEstampa;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public EstiloCamiseta getEstiloCamiseta() {
		return estiloCamiseta;
	}

	public void setEstiloCamiseta(EstiloCamiseta estiloCamiseta) {
		this.estiloCamiseta = estiloCamiseta;
	}

	public Estampa getEstampa() {
		return estampa;
	}

	public void setEstampa(Estampa estampa) {
		this.estampa = estampa;
	}
	
	public Long getPrecioTotalCalculado() {
		return (this.estampa.getPrecio()+this.estiloCamiseta.getPrecio())*this.cantidad;
	}
	
	public Long getCantidad(){
		return this.cantidad;
	}
	
	public void setCantidad(Long cantidad){
		this.cantidad = cantidad;
	}
	

}
