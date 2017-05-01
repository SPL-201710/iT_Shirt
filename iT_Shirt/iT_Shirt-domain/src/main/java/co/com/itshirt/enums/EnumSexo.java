package co.com.itshirt.enums;

/**
 * Sexos.
 */
public enum EnumSexo {
	
	MASCULINO ("M", "Masculino"),
	FEMENINO ("F", "Femenino"),
	;
	
	public final static EnumSexo[] ENUM_VALUES = EnumSexo.values();
	
	private String codigo;
	private String descripcion;
	
	private EnumSexo(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
