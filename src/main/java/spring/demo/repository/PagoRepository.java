package spring.demo.repository;

import org.springframework.data.repository.CrudRepository;

import spring.demo.models.PagoModel;

public interface PagoRepository extends CrudRepository<PagoModel, Long> {
    
}
    

