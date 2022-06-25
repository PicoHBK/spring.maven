package spring.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.demo.models.UsuarioModels;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModels, Long> {

}
    
