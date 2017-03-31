package co.com.itshirt.dto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.domain.Rol;

public class UsuarioDTO {
	
	private Long idUsuario;
	private String username;
	private String password;
	private String nombres;
	private String apellidos;
	private String email;
	private String telefono;
    private Rol rol;
	private String passwordConfirm; //TODO Es temporal.
	
	/**
	 * Constructor vacio por defecto.
	 */
	public UsuarioDTO() {
		super();
	}
	
	/**
	 * Constructor a partir de entidad.
	 */
	public UsuarioDTO(final Usuario usuario) {
		super();
		this.idUsuario = usuario.getIdUsuario();
		this.username = usuario.getUsername();
		this.password = usuario.getPassword();
		this.nombres = usuario.getNombres();
		this.apellidos = usuario.getApellidos();
		this.email = usuario.getEmail();
		this.telefono = usuario.getTelefono();
		this.rol = usuario.getRol();
		this.passwordConfirm = usuario.getPasswordConfirm();
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
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
