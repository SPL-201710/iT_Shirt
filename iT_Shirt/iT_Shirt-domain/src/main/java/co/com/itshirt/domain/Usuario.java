package co.com.itshirt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usua_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usua_id")
	private Long idUsuario;
	
	@Column(name = "usua_nombre")
	private String username;
	
	@Column(name = "usua_clave")
	private String password;
	
	@Column(name = "usua_nombres")
	private String nombres;
	
	@Column(name = "usua_apellidos")
	private String apellidos;
	
	@Column(name = "usua_email")
	private String email;
	
	@Column(name = "usua_telefono")
	private String telefono;
	
	@Column(name = "usua_genero")
	private String genero;
	
	@Column(name = "usua_direccion")
	private String direccion;
	
	@Column(name = "usua_estado")
	private String estado;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rol_id")
    private Rol rol;
	
	@Column(name = "social_id")
	private String idRedSocial;
	
	@Column(name = "usua_estamdestacadas")
	private Long estampasDestacar;
	
	@Transient
	private String passwordConfirm; //TODO Es temporal.
	
	/**
	 * Constructor vacío por defecto.
	 */
	public Usuario() {
		super();
	}
	
	/**
	 * Constructor vacío por defecto.
	 */
	public Usuario(Usuario user) {
		super();
		this.idUsuario = user.idUsuario;
		this.username = user.username;
		this.password = user.password;
		this.nombres = user.nombres;
		this.apellidos = user.apellidos;
		this.email = user.email;
		this.telefono = user.telefono;
		this.rol = user.getRol();
		this.genero = user.genero;
		this.direccion = user.getDireccion();
		this.estado = user.getEstado();
		this.idRedSocial = user.getIdRedSocial();
		this.estampasDestacar = user.estampasDestacar; 
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
	
	public String getNombresCompletos() {
		return this.nombres + " " +  this.apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdRedSocial() {
		return idRedSocial;
	}

	public void setIdRedSocial(String idRedSocial) {
		this.idRedSocial = idRedSocial;
	}

	public Long getEstampasDestacar() {
		return estampasDestacar;
	}

	public void setEstampasDestacar(Long estampasDestacar) {
		this.estampasDestacar = estampasDestacar;
	}
	
}
