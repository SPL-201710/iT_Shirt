package co.com.itshirt.dto.variability.perfil;

/**
 * DTO encapsula la información del cambio de dirección de usuario.
 * @author ja.picon
 */
public class CambioDireccionDTO {
	
	private Long idUsuario;
	private String direccion;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public CambioDireccionDTO() {
		super();
	}
	
	public CambioDireccionDTO(final Long idUsuario, final String direccion) {
		super();
		this.idUsuario = idUsuario;
		this.direccion = direccion;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
