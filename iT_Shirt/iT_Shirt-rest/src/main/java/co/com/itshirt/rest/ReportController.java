package co.com.itshirt.rest;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.itshirt.dto.variability.ReporteVentaDTO;
import co.com.itshirt.repository.ReportesRepository;

/**
 * Controlador Rest reportes.
 * @author ja.picon
 * 
 */
@RestController
@RequestMapping("/rest/reporte")
public class ReportController {
	
	/**
	 * 
	 * TODO - Tener en cuenta no modificar los nombres ya que se usa 
	 * en menu builder para verificar si el servicio está.
	 * 
	 */
	
	@Autowired
	private ReportesRepository reportesRepository;
	
	@RequestMapping(value= "todasVentas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReporteVentaDTO> todasVentas() {
		final List<ReporteVentaDTO> reportes = reportesRepository.allVentas();
		return reportes;
	}
	
	@RequestMapping(value= "ventas/nombre/artista/{artista}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReporteVentaDTO> reporteArtistas(@PathVariable(value = "artista") String artista) throws ParseException {
		final List<ReporteVentaDTO> reportes = this.reportesRepository.filtrarPorNombreArtista(artista);
		return reportes;
	}
	
	@RequestMapping(value= "ventas/artista/{artista}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReporteVentaDTO> reporteCodigoArtistas(@PathVariable(value = "codigo") String codigo) throws ParseException {
		final List<ReporteVentaDTO> reportes = this.reportesRepository.filtrarCodigoArtista(codigo);
		return reportes;
	}
	
	@RequestMapping(value= "ventas/{fechaInicio}/{fechaFin}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReporteVentaDTO> ventasFiltro(@PathVariable(value = "fechaInicio") String fechaInicio,
			@PathVariable(value = "fechaFin") String fechaFin) throws ParseException {
		final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		final Date _fechaInicio = (Date) formatter.parse(fechaInicio);
		final Date _fechaFin = (Date) formatter.parse(fechaFin);
		java.sql.Timestamp fIni = new java.sql.Timestamp( _fechaInicio.getTime() ) ;
		java.sql.Timestamp fFin = new java.sql.Timestamp( _fechaFin.getTime() ) ;
		final List<ReporteVentaDTO> reportes = this.reportesRepository.allVentas();
		System.out.println("# "+ reportes.size());
		final List<ReporteVentaDTO> itemsFiltrados = new ArrayList<ReporteVentaDTO>();
		if (reportes != null && !reportes.isEmpty()) {
			for (ReporteVentaDTO reporteVentaDTO : reportes) {
				System.out.println("Fecha COMPRA: " + reporteVentaDTO.getFechaCompra());
				if(reporteVentaDTO.getFechaCompra().after(fIni) && reporteVentaDTO.getFechaCompra().before(fFin)) {
				    // In between
					itemsFiltrados.add(reporteVentaDTO);
				}
			}
		}
		return itemsFiltrados;
	}
	
    
}
