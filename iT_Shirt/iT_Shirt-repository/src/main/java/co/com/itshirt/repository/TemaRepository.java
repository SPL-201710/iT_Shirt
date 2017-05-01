package co.com.itshirt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.itshirt.domain.Tema;

@Repository
public interface TemaRepository extends CrudRepository<Tema, Long>{

}
