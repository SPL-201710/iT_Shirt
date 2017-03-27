package co.com.itshirt.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends CrudRepository<Tema, Long>{

}
