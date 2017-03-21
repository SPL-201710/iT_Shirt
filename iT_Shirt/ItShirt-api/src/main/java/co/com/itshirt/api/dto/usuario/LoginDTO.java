package co.com.itshirt.api.dto.usuario;

/**
 * DTO que encapsula la información del login.
 * @author julianpicon
 *
 */
public class LoginDTO {
	
	private String usuario;
	private String contrasenia;
	
	/**
	 * Constructor por defecto.
	 */
	public LoginDTO() {
		
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
