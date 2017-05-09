package co.com.itshirt.repository.vip;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.itshirt.domain.DetalleOrden;
import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.OrdenCompra;
import co.com.itshirt.domain.vip.DetalleOrdenVIP;

public interface DetalleOrdenVIPRepository extends CrudRepository<DetalleOrdenVIP, Long>  {
	
	
}
