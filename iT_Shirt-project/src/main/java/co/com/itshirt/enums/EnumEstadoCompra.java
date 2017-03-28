package co.com.itshirt.enums;

/**
 * Lista de estados de las compras.
 * @author ja.picon
 *
 */
public enum EnumEstadoCompra {
	
	PENDIENTE ("PEND", "Pago Pendiente"),
	RECHAZADO ("RECH", "Pago Rechazado"),
	PROCESADO ("PROC", "Pago Procesado"),
	;
	
	public final static EnumEstadoCompra[] ENUM_VALUES = EnumEstadoCompra.values();
	
	private String sigla;
	private String nombre;
	
	private EnumEstadoCompra(String sigla, String nombre) {
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
