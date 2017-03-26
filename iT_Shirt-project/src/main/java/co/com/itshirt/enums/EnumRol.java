package co.com.itshirt.enums;

/**
 * Roles del sistema.
 * @author ja.picon
 *
 */
public enum EnumRol {
	
	ADMINISTRADOR ("ADMIN", "Administrador"),
	ARTISTA ("ARTI", "Artista"),
	COMPRADOR ("COMPR", "Comprador"),
	;
	
	public final static EnumRol[] ENUM_VALUES = EnumRol.values();
	
	private String sigla;
	private String nombre;
	
	private EnumRol(String sigla, String nombre) {
		this.sigla = sigla;
		this.nombre = nombre;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
