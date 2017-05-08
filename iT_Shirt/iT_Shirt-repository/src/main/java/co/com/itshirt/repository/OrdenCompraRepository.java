package co.com.itshirt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.itshirt.domain.OrdenCompra;

public interface OrdenCompraRepository extends CrudRepository<OrdenCompra, Long>{

	public List<OrdenCompra> findByIdUsuario(Long idUsusario);
	
}
