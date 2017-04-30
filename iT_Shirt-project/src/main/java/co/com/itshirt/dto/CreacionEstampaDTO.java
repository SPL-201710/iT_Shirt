package co.com.itshirt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import co.com.itshirt.domain.Estampa;

/**
 * Información nueva estampa
 * @author ja.picon
 *
 */
public class CreacionEstampaDTO {
	
	@NotNull
    @Size(max=50)
	private String NombreCorto;
	@NotNull
    @Size(max=50)
	private String descripcion;
	private MultipartFile file;
//	@Min(value = 0L, message = "El valor debe ser positivo")
//	@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Sólo debe ser un valor entero.") //Por facilidad.
	private Long precio;
	private String estado;
    private Long idTema;
    
<<<<<<< HEAD
	public String getNombreCorto() {
		return NombreCorto;
=======
    //Para la edición.
    private Long idEstampa;
    
    public CreacionEstampaDTO() {
		// TODO Auto-generated constructor stub
	}
    
    public CreacionEstampaDTO(Estampa estampa) {
		this.idEstampa = estampa.getIdEstampa();
		this.idTema = estampa.getTema().getIdTema();
		this.estaNombreCorto = estampa.getEstaNombreCorto();
		this.descripcion = estampa.getDescripcion();
		this.precio = estampa.getPrecio();
	}
    
    
	public String getEstaNombreCorto() {
		return estaNombreCorto;
>>>>>>> 5a9a5fa48595b648480eee39450c1aaf8a348316
	}
	public void setNombreCorto(String estaNombreCorto) {
		this.NombreCorto = estaNombreCorto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
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
	public Long getIdTema() {
		return idTema;
	}
	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}
	public Long getIdEstampa() {
		return idEstampa;
	}
	public void setIdEstampa(Long idEstampa) {
		this.idEstampa = idEstampa;
	}
    
}
