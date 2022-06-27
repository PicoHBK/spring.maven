package spring.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.demo.models.PrioridadModel;

@Repository
public interface PrioridadRepository extends CrudRepository<PrioridadModel, Long> {

}
    
