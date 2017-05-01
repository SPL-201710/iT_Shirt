package co.com.itshirt.enums;

/**
 * Lista de estilos de camiseta.
 * @author ja.picon
 *
 */
public enum EnumEstilosCamiseta {
	
	MANGA_CORTA ("MC", "Manga corta"),
	MANGA_LARGA ("ML", "Manga larga"),
	MANGA_SISA ("MS", "Manga sisa"),
	;
	
	public final static EnumEstilosCamiseta[] ENUM_VALUES = EnumEstilosCamiseta.values();
	
	private String sigla;
	private String nombre;
	
	private EnumEstilosCamiseta(String sigla, String nombre) {
		this.sigla = sigla;
		this.nombre = nombre;
	}
	
	/**
	 * Obtiene el enum por la sigla.
	 * @param sigla
	 * @return
	 */
	public static EnumEstilosCamiseta get(String sigla) {
		for (EnumEstilosCamiseta enumEstilosCamiseta : ENUM_VALUES) {
			if (enumEstilosCamiseta.sigla.equals(sigla)) {
				return enumEstilosCamiseta;
			}
		}
		return null;
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
