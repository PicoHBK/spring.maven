package spring.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.demo.models.PagoModel;
@Repository
public interface PagoRepository extends CrudRepository<PagoModel, Long> {
    
}
    

