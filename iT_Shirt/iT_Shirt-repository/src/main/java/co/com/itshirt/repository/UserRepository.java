package co.com.itshirt.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.domain.UsuarioTema;

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
	
	@Modifying
	@Transactional
	@Query("UPDATE Usuario u SET u.direccion = ?1  WHERE u.idUsuario = ?2")
    public void actualizarDireccion(String direccion, long id);
	
    
	
	@Query("SELECT u.email FROM Usuario u WHERE u.idUsuario=?1")
	public List<String> findEmailUsuario(Long idUsuario);

	
	@Query("SELECT u.email FROM Usuario u")
	public List<String> findAllEmail();
	
	//(select usuario_id from usua_tema where tema_id=1);
	@Query("SELECT usua.email FROM UsuarioTema ut JOIN ut.usuario usua JOIN ut.tema tem WHERE tem.idTema =?1")
	public List<String> findByTema(Long tema);
	
	
}