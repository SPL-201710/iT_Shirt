package co.com.itshirt.api.dto.usuario;

/**
 * DTO que encapsula la información del login.
 * @author julianpicon
 *
 */
public class LoginDTO {
	
	private String usuario;
	private String contrasenia;
	private String username;
	private String password;
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
