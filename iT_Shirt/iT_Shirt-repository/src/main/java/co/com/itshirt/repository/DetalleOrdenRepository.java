package co.com.itshirt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.itshirt.domain.DetalleOrden;
import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.OrdenCompra;

public interface DetalleOrdenRepository extends CrudRepository<DetalleOrden, Long>  {
	
	public List<DetalleOrden> findByOrdenCompra(OrdenCompra orden);
	
	public List<DetalleOrden> findByEstampa(Estampa estampa);
	
}
