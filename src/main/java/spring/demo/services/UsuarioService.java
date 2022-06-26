package spring.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.models.UsuarioModels;
import spring.demo.repository.UsuarioRepository;

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
}
