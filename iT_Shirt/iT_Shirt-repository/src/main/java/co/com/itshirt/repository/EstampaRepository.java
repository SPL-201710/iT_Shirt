package co.com.itshirt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.itshirt.domain.Estampa;
import co.com.itshirt.domain.Tema;
import co.com.itshirt.domain.Usuario;

/**
 * Repositorio acceso a datos Estampa.
 **/
@Repository
public interface EstampaRepository extends CrudRepository<Estampa, Long> {
    
	public Iterable<Estampa> findByArtistaOrderByIdEstampaDesc(Usuario artista);
	
	public List<Estampa> findByTema(Tema tema);
	
	@Query("SELECT e FROM Estampa e WHERE e.tema = ?1 AND e.estado = ?2")
    public List<Estampa> find(Tema tema, String estado);
	
	@Query("SELECT e FROM Estampa e WHERE e.estado = ?1")
    public List<Estampa> findAll(String estado);
	
	@Modifying
	@Transactional
	@Query("UPDATE Estampa e SET e.estado = ?1 WHERE e.idEstampa = ?2")
    public void updateEstado(String estado, long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Estampa e SET e.destacada = ?1 WHERE e.idEstampa = ?2")
	public void updateDestacada(String destacada, long id);
	
}