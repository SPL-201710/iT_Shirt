package co.com.itshirt.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.itshirt.domain.DetalleOrden;

public class PersonalizacionDTO {
	
	private Long idDetalle;
	
	@NotNull
    @Size(max=2)
	private String talla;
	
	@NotNull
    @Size(max=50)
	private String color;
	
	@NotNull
    @Size(max=50)
	private String textoConfigurado;
	
	private Long precioCamiseta;

	private Long precioEstampa;
	
	@NotNull
	private Long estiloCamiseta;
	@NotNull
	private Long estampa;
	@NotNull
	private Long ordenCompra;

    
	
	public PersonalizacionDTO() {
		super();
	}
	
	public PersonalizacionDTO(DetalleOrden entity) {
		super();
		this.idDetalle = entity.getIdDetalle();
		this.talla = entity.getTalla();
		this.color = entity.getColor();
		this.textoConfigurado = entity.getTextoConfigurado();
		this.precioCamiseta = entity.getPrecioCamiseta();
		this.precioEstampa = entity.getPrecioEstampa();
	}
	
	public DetalleOrden toEntity() {
		final DetalleOrden entity = new DetalleOrden();
		entity.setIdDetalle(this.idDetalle);
		entity.setTalla(this.talla);
		entity.setColor(this.color);
		entity.setTextoConfigurado(this.textoConfigurado);
		entity.setPrecioCamiseta(this.precioCamiseta);
		entity.setPrecioEstampa(this.precioEstampa);
		return entity;
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

    
    public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
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

	public Long getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(Long ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public Long getEstampa() {
		return estampa;
	}

	public void setEstampa(Long estampa) {
		this.estampa = estampa;
	}

	public Long getEstiloCamiseta() {
		return estiloCamiseta;
	}

	public void setEstiloCamiseta(Long estiloCamiseta) {
		this.estiloCamiseta = estiloCamiseta;
	}
	
}
