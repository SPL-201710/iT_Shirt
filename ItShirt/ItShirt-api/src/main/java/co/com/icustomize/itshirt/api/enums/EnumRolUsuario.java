package co.com.icustomize.itshirt.api.enums;

/**
 * Enum con los distintos valores de los roles del sistema.
 * 
 * @author Julián Picón
 * @since 05/03/2017
 *
 */
public enum EnumRolUsuario {
	
	ADMINISTRADOR("ADMIN"),
	COMPRADOR("COMPR"),
	ARTISTA("ARTIS");
	
	private String nombreCorto;
	
	public EnumRolUsuario[] ENUM_VALUES = EnumRolUsuario.values();
	
	/**
	 * Constructor del enum.
	 * @param nombreCorto Nombre corto del rol.
	 */
	private EnumRolUsuario(final String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}	

}
