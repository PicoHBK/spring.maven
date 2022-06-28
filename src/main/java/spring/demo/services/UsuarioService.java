package spring.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import spring.demo.models.UsuarioModels;
import spring.demo.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioModels> getUsuarios() {
        
        return (List<UsuarioModels>) usuarioRepository.findAll();
    }

    public UsuarioModels guardarUsuario(UsuarioModels usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModels> obtenerPorId(long id) {
        return usuarioRepository.findById(id);
    }

    public List<UsuarioModels> obtenerPorTelefono(long telefono) {
        return usuarioRepository.findByTelefono(telefono);
    }
    
    public List<UsuarioModels> findByName( String name){
        return usuarioRepository.findByName(name);
    }

    public List<UsuarioModels> findByLastName(String LastName){
        return usuarioRepository.findByLastName(LastName);
    }

    public List<UsuarioModels> searchTelefono(long telefono){
        return usuarioRepository.search(telefono);
    }
    public boolean borrarUsuario(long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    // 
    // IMPLEMENTACION DE LA PAGINACION USA LA LIBREARIA org.springframework.data.domain.Pageable;
    //
    public List<UsuarioModels> obtenerPorPaginacion(Pageable pageable)
    {
        return usuarioRepository.findAll(pageable).getContent();
    }
}
