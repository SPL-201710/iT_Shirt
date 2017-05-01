package co.com.itshirt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.itshirt.domain.OrdenCompra;
import co.com.itshirt.domain.Usuario;


public interface OrdenCompraRepository extends CrudRepository<OrdenCompra, Long>{

	public List<Usuario> findByIdUsuario(Long idUsusario);
	
}
