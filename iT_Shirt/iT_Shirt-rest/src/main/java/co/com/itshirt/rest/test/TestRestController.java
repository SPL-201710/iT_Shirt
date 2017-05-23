package co.com.itshirt.rest.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.itshirt.dto.variability.ReporteVentaDTO;


/**
 * Controlador Rest.
 * @author ja.picon
 * 
 * https://spring.io/guides/tutorials/bookmarks/
 * 
 */
@RestController
@RequestMapping("/rest")
public class TestRestController {
	

	@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsuarios() {
        return "test";
    }
	
	@RequestMapping(value= "/venta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ReporteVentaDTO getForObjectJsonDemo(@PathVariable(value = "id") Integer id) {
//		ReporteVentaDTO reporte = new ReporteVentaDTO("VENTA_"+id,"10.0000", new Date());
		return new ReporteVentaDTO();
	} 
	
	@RequestMapping(value= "/ventas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReporteVentaDTO> getForObjectJsonDemos(@PathVariable(value = "id") Integer id) {
//		ReporteVentaDTO reporte = new ReporteVentaDTO("VENTA_"+id,"10.0000", new Date());
		return Arrays.asList(new ReporteVentaDTO(), new ReporteVentaDTO());
	} 
    
}
