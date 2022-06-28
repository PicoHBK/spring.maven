package spring.demo.repository;

import org.springframework.data.repository.CrudRepository;

import spring.demo.models.AdminModel;

public interface AdminRepository extends CrudRepository<AdminModel, Long> {

}
    
