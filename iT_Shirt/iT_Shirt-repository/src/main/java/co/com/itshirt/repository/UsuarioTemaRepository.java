package co.com.itshirt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.domain.UsuarioTema;

@Repository
public interface UsuarioTemaRepository extends CrudRepository<UsuarioTema, Long>{
	
	public List<UsuarioTema> findByUsuario(Usuario usuario);
	
		
	
	
}
