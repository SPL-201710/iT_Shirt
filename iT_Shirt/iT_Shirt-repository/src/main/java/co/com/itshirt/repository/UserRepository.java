package co.com.itshirt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.itshirt.domain.Usuario;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {
    
	public Usuario findByUsername(String username);
    
}