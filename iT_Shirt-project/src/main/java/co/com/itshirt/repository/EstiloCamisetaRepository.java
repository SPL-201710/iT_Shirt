package co.com.itshirt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.itshirt.domain.EstiloCamiseta;

/**
 * Repositorio acceso a datos Estilos de camiseta.
 **/
@Repository
public interface EstiloCamisetaRepository extends CrudRepository<EstiloCamiseta, Long> {
    
	
}