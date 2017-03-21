package co.com.itshirt.api.enums;

/**
 * Enum con los distintos modulos del proyecto iT_Shirt.
 * @author julianpicon
 *
 */
public enum EnumModulos {
	
	ADMINISTRACION ("administracion-web"), 
	CATALOGO ("catalogo-web"),
	AUTENTICACION ("autenticacion-web"), 
	PERSONALIZACION ("personalizacion-web")
	;

    private final String contextPath;

    /**
     * Constructor del enum.
     * @param contextPath
     */
    EnumModulos(String contextPath) {
        this.contextPath = contextPath;
    }

	public String getContextPath() {
		return contextPath;
	}

}
