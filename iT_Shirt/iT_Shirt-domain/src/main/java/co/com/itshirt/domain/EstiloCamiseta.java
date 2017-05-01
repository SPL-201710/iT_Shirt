package co.com.itshirt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cata_estilocamiseta")
public class EstiloCamiseta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "esti_id")
	private Long idEstilo;
	
	@Column(name = "esti_nombre")
	private String nombre;
	
	@Column(name = "esti_estilo")
	private String estilo;
	
	@Column(name = "esti_material")
	private String material;
	
	@Column(name = "esti_precio")
	private Long precio;
	
	@Column(name = "esti_extension")
	private String extension;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public EstiloCamiseta() {
		super();
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
