package co.com.itshirt.enums;

/**
 * Estados de las estampas
 * @author ja.picon
 *
 */
public enum EnumEstadoEstampa {
	
	ACTIVA ("A"),
	INACTIVA ("I"),
	RECHAZADA ("R"), 
	;
	
	public final static EnumEstadoEstampa[] ENUM_VALUES = EnumEstadoEstampa.values();
	
	private String codigo;
	
	private EnumEstadoEstampa(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
