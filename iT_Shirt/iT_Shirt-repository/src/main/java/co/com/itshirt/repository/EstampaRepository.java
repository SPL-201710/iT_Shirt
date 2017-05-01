package co.com.itshirt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
	
}