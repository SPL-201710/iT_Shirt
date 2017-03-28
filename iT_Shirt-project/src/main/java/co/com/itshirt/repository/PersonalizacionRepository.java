package co.com.itshirt.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.itshirt.domain.*;

public interface PersonalizacionRepository extends CrudRepository<DetalleOrden, Long>  {
	
}
