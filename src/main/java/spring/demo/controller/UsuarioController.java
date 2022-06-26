package spring.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModels> obtenerPorId(@PathVariable long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path = "/telefono/{telefono}")
    public List<UsuarioModels> obtenerPorTelefono(@PathVariable long telefono){
        return this.usuarioService.obtenerPorTelefono(telefono);
    }
    
    @GetMapping(path = "/query")
    public List<UsuarioModels> findByName(@RequestParam("name") String name){
        return this.usuarioService.findByName(name);
    }

    @GetMapping(path = "/query2")
    public List<UsuarioModels> findByLastName( @RequestParam("lastName") String lastName){
        return this.usuarioService.findByLastName(lastName);
    }

    @GetMapping(path = "/query3")
    public List<UsuarioModels> searchTelefono(@RequestParam("telefono") long telefono){
        //return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.searchTelefono(telefono));
        return this.usuarioService.searchTelefono(telefono);
    }
}
