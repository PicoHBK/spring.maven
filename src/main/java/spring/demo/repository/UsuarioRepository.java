package spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.demo.models.UsuarioModels;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModels, Long> {

    public abstract List<UsuarioModels> findByTelefono( long telefono);
    public abstract List<UsuarioModels> findByName( String name);
    public abstract List<UsuarioModels> findByLastName( String LastName);

    @Query(value = "SELECT * FROM spring.usuario WHERE usuario.telefono  LIKE %:tel% GROUP BY usuario.name ORDER BY usuario.telefono DESC" , nativeQuery = true)
    List<UsuarioModels> search(@Param("tel") long telefono);

}
    
