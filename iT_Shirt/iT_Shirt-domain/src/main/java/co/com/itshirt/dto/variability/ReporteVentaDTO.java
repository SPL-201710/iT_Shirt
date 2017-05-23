package co.com.itshirt.dto.variability;

import java.util.Date;

public class ReporteVentaDTO {
	
	private Long idOrden;
	private Long codigoEstampa;
	private Long precioEstampa;
	private Long precioCamiseta;
	private Long totalCompra;
	private Date fechaCompra;
	private String artista;
	
	public ReporteVentaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ReporteVentaDTO(Long idOrden) {
		super();
		this.idOrden = idOrden;
	}

	public ReporteVentaDTO(Long idOrden, Long codigoEstampa, Long precioEstampa, Long precioCamiseta,
			Long totalCompra, Date fechaCompra) {
		super();
		this.idOrden = idOrden;
		this.codigoEstampa = codigoEstampa;
		this.precioEstampa = precioEstampa;
		this.precioCamiseta = precioCamiseta;
		this.totalCompra = totalCompra;
		this.fechaCompra = fechaCompra;
	}
	
	public ReporteVentaDTO(Long idOrden, Long codigoEstampa, Long precioEstampa, Long precioCamiseta,
			Long totalCompra, Date fechaCompra, String artista) {
		this(idOrden, codigoEstampa, precioEstampa, precioCamiseta, totalCompra, fechaCompra);
		this.artista = artista;
	}

	public Long getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Long idOrden) {
		this.idOrden = idOrden;
	}

	public Long getCodigoEstampa() {
		return codigoEstampa;
	}

	public void setCodigoEstampa(Long codigoEstampa) {
		this.codigoEstampa = codigoEstampa;
	}

	public Long getPrecioEstampa() {
		return precioEstampa;
	}

	public void setPrecioEstampa(Long precioEstampa) {
		this.precioEstampa = precioEstampa;
	}

	public Long getPrecioCamiseta() {
		return precioCamiseta;
	}

	public void setPrecioCamiseta(Long precioCamiseta) {
		this.precioCamiseta = precioCamiseta;
	}

	public Long getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Long totalCompra) {
		this.totalCompra = totalCompra;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
	
}
