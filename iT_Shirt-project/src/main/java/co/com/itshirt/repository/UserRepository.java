package co.com.itshirt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.Rol;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {
    
	public Usuario findByUsername(String username);
	public Iterable<Usuario> findByRol(Rol rol);
    
}