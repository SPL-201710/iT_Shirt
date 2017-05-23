package co.com.itshirt.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.itshirt.domain.DetalleOrden;
import co.com.itshirt.dto.variability.ReporteVentaDTO;

public interface ReportesRepository extends CrudRepository<DetalleOrden, Long>  {
	
	@Query("SELECT new co.com.itshirt.dto.variability.ReporteVentaDTO"
			+ "(oc.idOrdenCompra, est.idEstampa, do.precioEstampa, do.precioCamiseta, oc.total, oc.fecha) "
			+ "FROM DetalleOrden do JOIN do.ordenCompra oc JOIN do.estampa est JOIN do.estiloCamiseta cam "
			+ "ORDER BY oc.fecha desc")
	public List<ReporteVentaDTO> allVentas();
	
	@Query("SELECT new co.com.itshirt.dto.variability.ReporteVentaDTO"
			+ "(oc.idOrdenCompra, est.idEstampa, do.precioEstampa, do.precioCamiseta, oc.total, oc.fecha) "
			+ "FROM DetalleOrden do JOIN do.ordenCompra oc JOIN do.estampa est JOIN do.estiloCamiseta cam "
			+ "WHERE oc.fecha between ?1 and ?2 " //TODO 
			+ "ORDER BY oc.fecha desc")
	public List<ReporteVentaDTO> findVentas(Date fechaInicio, Date fechaFin);
	
	@Query("SELECT new co.com.itshirt.dto.variability.ReporteVentaDTO"
			+ "(oc.idOrdenCompra, est.idEstampa, do.precioEstampa, do.precioCamiseta, oc.total, oc.fecha, concat(artis.nombres,' ',artis.apellidos)) "
			+ "FROM DetalleOrden do JOIN do.ordenCompra oc JOIN do.estampa est JOIN do.estiloCamiseta cam "
			+ "JOIN est.artista artis "
			+ "WHERE lower(artis.nombres) = lower(?1) or  lower(artis.apellidos) = lower(?1) "
			+ "ORDER BY oc.fecha desc ")
	public List<ReporteVentaDTO> filtrarPorNombreArtista(String artista);
	
	@Query("SELECT new co.com.itshirt.dto.variability.ReporteVentaDTO"
			+ "(oc.idOrdenCompra, est.idEstampa, do.precioEstampa, do.precioCamiseta, oc.total, oc.fecha, concat(artis.nombres,' ',artis.apellidos)) "
			+ "FROM DetalleOrden do JOIN do.ordenCompra oc JOIN do.estampa est JOIN do.estiloCamiseta cam "
			+ "JOIN est.artista artis "
			+ "WHERE idUsuario = ?1 "
			+ "ORDER BY oc.fecha desc ")
	public List<ReporteVentaDTO> filtrarCodigoArtista(String codigoArtista);
	
}