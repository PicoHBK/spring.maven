package spring.demo.services;

import java.util.List;

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
}
