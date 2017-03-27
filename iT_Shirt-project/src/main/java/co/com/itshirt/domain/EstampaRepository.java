package co.com.itshirt.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.itshirt.domain.Usuario;

/**
 * Repositorio acceso a datos Estampa.
 **/
@Repository
public interface EstampaRepository extends CrudRepository<Estampa, Long> {
    
    
}