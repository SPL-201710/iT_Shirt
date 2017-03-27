package co.com.itshirt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.itshirt.domain.EstiloCamiseta;
import co.com.itshirt.enums.EnumEstilosCamiseta;

/**
 * Información estilos camiseta
 * @author ja.picon
 *
 */
public class EstiloCamisetaDTO {
    
	private Long idEstilo;
	@NotNull
    @Size(max=50)
	private String nombre;
	@NotNull
    @Size(max=50)
	private String estilo;
	@NotNull
    @Size(max=50)
	private String material;
	private Long precio;
    
	public EstiloCamisetaDTO() {
		super();
	}
	
	public EstiloCamisetaDTO(EstiloCamiseta entity) {
		super();
		this.idEstilo = entity.getIdEstilo();
		this.nombre = entity.getNombre();
		this.estilo = entity.getEstilo();
		this.material = entity.getMaterial();
		this.precio = entity.getPrecio();
	}
	
	public EstiloCamiseta toEntity() {
		final EstiloCamiseta entity = new EstiloCamiseta();
		entity.setIdEstilo(this.idEstilo);
		entity.setNombre(this.nombre);
		entity.setEstilo(this.estilo);
		entity.setMaterial(this.material);
		entity.setPrecio(this.precio);
		return entity;
	}
	
	public Long getIdEstilo() {
		return idEstilo;
	}

	public void setIdEstilo(Long idEstilo) {
		this.idEstilo = idEstilo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	
	public String getEstiloDescripcion() {
		if (this.estilo != null) {
			return EnumEstilosCamiseta.get(this.estilo).getNombre();
		}
		return "";
	}
	
}
