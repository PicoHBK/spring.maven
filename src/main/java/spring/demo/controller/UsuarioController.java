package spring.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import spring.demo.models.PrioridadModel;
import spring.demo.models.UsuarioModels;
import spring.demo.services.PrioridadService;
import spring.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    // auto instanciar el servicio
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PrioridadService prioridadService;

   //
   // CONSIGUE TODOS LOS USUARIOS EN JSON
   //
    @GetMapping()
    public List<UsuarioModels> getUsuarios(){
        return usuarioService.getUsuarios();
    }
    //
   // CONSIGUE TODAS LAS PRIORIDADES EN JSON
   //
    @RequestMapping("/prioridad")
    public List<PrioridadModel> getPrioridades(){
        return prioridadService.getPrioridades();
    //
   // CARGA UNA PROIPIEDAD SE TIENE QUE MANDAR UN JSON
   //
    }
    @RequestMapping("/prioridad2")
    @PostMapping
    public PrioridadModel savePrioridad(@RequestBody PrioridadModel prioridad){
        return this.prioridadService.guardarPrioridad(prioridad);
    }

    //
   // CARGA UN USUARIO SE TIENE QUE MANDAR UN JSON
   //
    @PostMapping()
    public UsuarioModels guardarUsuario(@RequestBody UsuarioModels usuario){
        /*PrioridadModel prioridad = new PrioridadModel();
        prioridad.setIdPrioridad(1);
        prioridad.setTipo("Negrom");
        usuario.setIdPrioridad(prioridad);
        */
        return this.usuarioService.guardarUsuario(usuario);
    }
    //
   // BUSQUEDA POR ID MANDANDO EL ID DESDE EL PATH DEVUELVE UN JSON
   //
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModels> obtenerPorId(@PathVariable long id){
        return this.usuarioService.obtenerPorId(id);
    }
    //
   // BUSQUEDA POR TELEFONO MANDANDO EL TELEFONO DESDE EL PATH DEVUELVE UN JSON
   //
    @GetMapping(path = "/telefono/{telefono}")
    public List<UsuarioModels> obtenerPorTelefono(@PathVariable long telefono){
        return this.usuarioService.obtenerPorTelefono(telefono);
    }
    //
   // CONSIGUE TODOS LOS USUARIOS POR NOMBRE MANDANDO EL NOMBRE CON QUERY EN EL PATH
   //
    @GetMapping(path = "/query")
    public List<UsuarioModels> findByName(@RequestParam("name") String name){
        return this.usuarioService.findByName(name);
    }
    //
   // CONSIGUE TODOS LOS USUARIOS POR APELLIDO MANDANDO EL APELLIDO CON QUERY EN EL PATH
   //
    @GetMapping(path = "/query2")
    public List<UsuarioModels> findByLastName( @RequestParam("lastName") String lastName){
        return this.usuarioService.findByLastName(lastName);
    }
    //
   // CONSIGUE TODOS LOS USUARIOS POR TELEFONO MANDANDO EL TELEFONO CON QUERY EN EL PATH
   //
    @GetMapping(path = "/query3")
    public List<UsuarioModels> searchTelefono(@RequestParam("telefono") long telefono){
        //return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.searchTelefono(telefono));
        return this.usuarioService.searchTelefono(telefono);
    }
    //
    // BORRAR POR ID
    //

    @DeleteMapping(path = "/borrar/{id}")
    public boolean borrarPorId(@PathVariable long id){
        return this.usuarioService.borrarUsuario(id);
    }
}
