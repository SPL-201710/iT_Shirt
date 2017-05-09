package co.com.itshirt.repository.vip;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import co.com.itshirt.domain.vip.SuscripcionVIP;

public interface SuscripcionVIPRepository extends CrudRepository<SuscripcionVIP, Long>  {
	
	/**
	 * Consultar suscripciones ordenadas.
	 */
	@Query("Select vip from SuscripcionVIP vip order by vip.estado, vip.idSuscripcion desc")
	public List<SuscripcionVIP> findAllOrderId();
	
	/**
	 * Consultar suscripciones por estado.
	 */
	@Query("Select vip from SuscripcionVIP vip WHERE vip.estado = ?1")
	public List<SuscripcionVIP> findByEstado(String estado);
	
	/**
	 * Actualizar estado de la suscripción.
	 */
	@Modifying
	@Transactional
	@Query("UPDATE SuscripcionVIP vip SET vip.estado = ?1 WHERE vip.idSuscripcion = ?2")
    public void updateEstado(String estado, long id);
	
}
