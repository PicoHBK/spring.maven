package spring.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.demo.models.SocioModel;
@Repository
public interface SocioRepository extends CrudRepository<SocioModel, Long>{
    
}
