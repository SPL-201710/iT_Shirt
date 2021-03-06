package co.com.itshirt.dto;

import co.com.itshirt.domain.Estampa;

/**
 * Información estampa.
 * @author ja.picon
 *
 */
public class EstampaDTO {
	
	private Long idEstampa;
	private String nombreCorto;
	private String descripcion;
	private String url;
	private Long precio;
	private String estado;
	private String extension;
	private Long idArtista;
	private String nombresArtista;
	private String destacada;
	private float rating;
	private Long calificada;
	
	/**
	 * Constructor vacio por defecto.
	 */
	public EstampaDTO() {
		super();
	}
	
	/**
	 * Constructor a partir de entidad.
	 */
	public EstampaDTO(final Estampa estampa) {
		super();
		this.idEstampa = estampa.getIdEstampa();
		this.nombreCorto = estampa.getEstaNombreCorto();
		this.descripcion = estampa.getDescripcion();
		this.url = estampa.getUrl();
		this.precio = estampa.getPrecio();
		this.estado = estampa.getEstado();
		this.extension = estampa.getExtension();
		this.idArtista = estampa.getArtista().getIdUsuario();
		this.nombresArtista = estampa.getArtista().getNombresCompletos();
		this.destacada = estampa.getDestacada();
		this.rating = estampa.getRating();
		this.calificada = estampa.getCalificada();
	}

	public Long getIdEstampa() {
		return idEstampa;
	}

	public void setIdEstampa(Long idEstampa) {
		this.idEstampa = idEstampa;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public Long getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(Long idArtista) {
		this.idArtista = idArtista;
	}
	
	public String getNombresArtista() {
		return nombresArtista;
	}

	public void setNombresArtista(String nombresArtista) {
		this.nombresArtista = nombresArtista;
	}

	public String getDestacada() {
		return destacada;
	}

	public void setDestacada(String destacada) {
		this.destacada = destacada;
	}

	public String getSource() {
		return this.idArtista + "/" + this.idEstampa + "." + this.extension;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Long getCalificada() {
		return calificada;
	}

	public void setCalificada(Long calificada) {
		this.calificada = calificada;
	}
	
}
