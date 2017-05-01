package co.com.itshirt.dto;

import co.com.itshirt.domain.Usuario;

/**
 * DTO encapsula la información del perfil de usuario.
 * @author ja.picon
 */
public class PerfilUsuarioDTO {
	
	private Long idUsuario;
	private String username;
	private String password;
	private String nombres;
	private String apellidos;
	private String email;
	private String genero;
	private String telefono;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public PerfilUsuarioDTO() {
		super();
	}
	
	/**
	 * Constructor vacío a partir de entidad Usuario.
	 */
	public PerfilUsuarioDTO(final Usuario usuario) {
		super();
		this.idUsuario = usuario.getIdUsuario();
		this.username = usuario.getUsername();
		this.password = usuario.getPassword();
		this.nombres = usuario.getNombres();
		this.apellidos = usuario.getApellidos();
		this.email = usuario.getEmail();
		this.genero = usuario.getGenero();
		this.telefono = usuario.getTelefono();
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
