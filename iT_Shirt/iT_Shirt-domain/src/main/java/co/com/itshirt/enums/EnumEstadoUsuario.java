package co.com.itshirt.enums;

/**
 * Estados del usuario.
 * @author ja.picon
 *
 */
public enum EnumEstadoUsuario {
	
	ACTIVO ("A", "Administrador"),
	INACTIVO ("I", "Artista"),
	;
	
	public final static EnumEstadoUsuario[] ENUM_VALUES = EnumEstadoUsuario.values();
	
	private String sigla;
	private String nombre;
	
	private EnumEstadoUsuario(String sigla, String nombre) {
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
