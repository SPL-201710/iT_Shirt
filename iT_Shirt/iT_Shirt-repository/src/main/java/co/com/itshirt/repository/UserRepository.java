package co.com.itshirt.repository;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.itshirt.domain.Usuario;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {
    
	public Usuario findByUsername(String username);
	
	public Usuario findByIdRedSocial(String idRedSocial);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Usuario u SET u.estado = ?1 WHERE u.idUsuario = ?2")
    public void updateEstado(String estado, long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Usuario u SET u.estampasDestacar = u.estampasDestacar + ?1  WHERE u.idUsuario = ?2")
    public void updateSuscripVIPEstampas(long cant_destacar, long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Usuario u SET u.estampasDestacar = ?1  WHERE u.idUsuario = ?2")
    public void inicialSuscripVIP(long cant_destacar, long id);
	
    
}