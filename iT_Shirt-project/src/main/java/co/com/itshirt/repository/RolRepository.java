package co.com.itshirt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.itshirt.domain.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {
    
	public Rol findBySigla(String sigla);
    
}