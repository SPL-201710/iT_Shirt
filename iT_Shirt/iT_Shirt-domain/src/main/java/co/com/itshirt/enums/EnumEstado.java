package co.com.itshirt.enums;

/**
 * Lista de estados Activo/Inactivo
 * @author ja.picon
 *
 */
public enum EnumEstado {
	
	ACTIVO ("A", "Activo"),
	INACTIVO ("I", "Inactivo"),
	;
	
	public final static EnumEstado[] ENUM_VALUES = EnumEstado.values();
	
	private String sigla;
	private String nombre;
	
	private EnumEstado(String sigla, String nombre) {
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
