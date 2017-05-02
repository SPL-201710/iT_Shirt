package co.com.itshirt.enums;

/**
 * Sexos.
 */
public enum EnumSexo {
	
	MASCULINO ("M", "Masculino", "male"),
	FEMENINO ("F", "Femenino", "female"),
	;
	
	public final static EnumSexo[] ENUM_VALUES = EnumSexo.values();
	
	private String codigo;
	private String descripcion;
	private String valorFacebook;
	
	private EnumSexo(String codigo, String descripcion, String valorFacebook) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.valorFacebook = valorFacebook;
	}

	/**
	 * Obtiene el enum por valorFacebook.
	 * @param valorFacebook
	 * @return
	 */
	public static EnumSexo getValorFacebook(String valorFacebook) {
		for (EnumSexo sexo : ENUM_VALUES) {
			if (sexo.valorFacebook.equals(valorFacebook)) {
				return sexo;
			}
		}
		return null;
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

	public String getValorFacebook() {
		return valorFacebook;
	}

	public void setValorFacebook(String valorFacebook) {
		this.valorFacebook = valorFacebook;
	}
	
}
