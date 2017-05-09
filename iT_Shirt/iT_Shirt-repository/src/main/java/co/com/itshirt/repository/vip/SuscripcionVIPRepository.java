package co.com.itshirt.repository.vip;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.itshirt.domain.vip.SuscripcionVIP;

public interface SuscripcionVIPRepository extends CrudRepository<SuscripcionVIP, Long>  {
	
	@Query("Select vip from SuscripcionVIP vip WHERE vip.estado = ?1")
	public List<SuscripcionVIP> findByEstado(String estado);
	
}
