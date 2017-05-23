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
	
	@Query("SELECT e FROM Estampa e WHERE e.estaNombreCorto like %?1% AND e.estado = ?2")
    public List<Estampa> findByNombre(String nombre, String estado);
	
	@Query("SELECT e FROM Estampa e WHERE e.rating >= 3.5 AND e.estado = ?1")
    public List<Estampa> findByRating(String estado);
	
	@Query("SELECT e FROM Estampa e WHERE e.tema = ?1 AND e.estado = ?2")
    public List<Estampa> find(Tema tema, String estado);
	
	@Query("SELECT e FROM Estampa e WHERE e.tema = ?1 AND e.estado = ?2 AND e.rating >= 3.5")
    public List<Estampa> findByTemaAndRating(Tema tema, String estado);
	
	@Query("SELECT e FROM Estampa e WHERE e.tema = ?1 AND e.estado = ?2 AND e.estaNombreCorto like %?3%")
    public List<Estampa> findByTemaAndNombre(Tema tema, String estado, String nombre);
	
	@Query("SELECT e FROM Estampa e WHERE e.estado = ?1 AND e.estaNombreCorto like %?2% AND e.rating >= 3.5")
    public List<Estampa> findByRatingAndNombre(String estado, String nombre);
	
	@Query("SELECT e FROM Estampa e WHERE e.tema = ?1 AND e.estado = ?2 AND e.estaNombreCorto like %?3% AND e.rating >= 3.5")
    public List<Estampa> findByTemaAndRatingAndNombre(Tema tema, String estado, String nombre);

	@Query("SELECT e FROM Estampa e WHERE e.tema = ?1 AND e.estado = ?2 AND e.destacada = ?3")
    public List<Estampa> find(Tema tema, String estado, String destacada);

	
	@Query("SELECT e FROM Estampa e WHERE e.estado = ?1 AND e.destacada = ?2")
    public List<Estampa> findAll(String estado, String destacada);
	
	@Query("SELECT e FROM Estampa e WHERE e.artista = ?1 AND e.destacada = ?2 ORDER BY e.idEstampa DESC")
	public List<Estampa> findDestArtista(Usuario artista, String destacada);
	
	@Modifying
	@Transactional
	@Query("UPDATE Estampa e SET e.estado = ?1 WHERE e.idEstampa = ?2")
    public void updateEstado(String estado, long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Estampa e SET e.destacada = ?1 WHERE e.idEstampa = ?2")
	public void updateDestacada(String destacada, long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Estampa e SET e.rating = ?1 WHERE e.idEstampa = ?2")
	public void updateRating(float calificacion, long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Estampa e SET e.calificada = e.calificada + 1 WHERE e.idEstampa = ?1")
	public void updateCalificada(long id);
	
	@Query("SELECT e.artista FROM Estampa e WHERE e.idEstampa = ?1")
	public Usuario findArtistaVIP(Long id);
	
}