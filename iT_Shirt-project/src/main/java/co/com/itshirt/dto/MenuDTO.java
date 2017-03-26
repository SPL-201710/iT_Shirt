package co.com.itshirt.dto;

/**
 * Información del menú.
 * @author ja.picon
 *
 */
public class MenuDTO {
	
	private String nombre;
	private String icono;
	private String peticion;
	
	public MenuDTO(String nombre, String icono, String peticion) {
		super();
		this.nombre = nombre;
		this.icono = icono;
		this.peticion = peticion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getPeticion() {
		return peticion;
	}

	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	
}
