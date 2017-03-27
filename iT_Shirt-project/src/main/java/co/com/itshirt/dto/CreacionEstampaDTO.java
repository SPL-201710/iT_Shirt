package co.com.itshirt.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

/**
 * Información nueva estampa
 * @author ja.picon
 *
 */
public class CreacionEstampaDTO {
	
	@NotNull
    @Size(max=50)
	private String estaNombreCorto;
	@NotNull
    @Size(max=50)
	private String descripcion;
	private MultipartFile file;
//	@Min(value = 0L, message = "El valor debe ser positivo")
//	@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Sólo debe ser un valor entero.") //Por facilidad.
	private Long precio;
	private String estado;
    private Long idTema;
    
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
    
}
