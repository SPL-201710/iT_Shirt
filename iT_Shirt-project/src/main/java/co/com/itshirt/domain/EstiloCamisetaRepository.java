package co.com.itshirt.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio acceso a datos Estilos de camiseta.
 **/
@Repository
public interface EstiloCamisetaRepository extends CrudRepository<EstiloCamiseta, Long> {
    
	
}