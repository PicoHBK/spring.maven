package spring.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import spring.demo.models.UsuarioModels;
import spring.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

   
    @GetMapping()
    public List<UsuarioModels> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping()
    public UsuarioModels guardarUsuario(@RequestBody UsuarioModels usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    
}
