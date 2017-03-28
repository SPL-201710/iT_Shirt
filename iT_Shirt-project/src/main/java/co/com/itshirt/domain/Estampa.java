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

@Entity
@Table(name = "cata_estampa")
public class Estampa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "esta_id")
	private Long idEstampa;
	
	@Column(name = "esta_nombrecorto")
	private String estaNombreCorto;
	
	@Column(name = "esta_descripcion")
	private String descripcion;
	
	@Column(name = "esta_url")
	private String url;
	
	@Column(name = "esta_precio")
	private Long precio;
	
	@Column(name = "esta_estado")
	private String estado;
	
	@Column(name = "esta_extension")
	private String extension;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tema_id")
    private Tema tema;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "artista_id")
    private Usuario artista;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public Estampa() {
		super();
	}

	public Long getIdEstampa() {
		return idEstampa;
	}

	public void setIdEstampa(Long idEstampa) {
		this.idEstampa = idEstampa;
	}

	public String getEstaNombreCorto() {
		return estaNombreCorto;
	}

	public void setEstaNombreCorto(String estaNombreCorto) {
		this.estaNombreCorto = estaNombreCorto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getArtista() {
		return artista;
	}

	public void setArtista(Usuario artista) {
		this.artista = artista;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
