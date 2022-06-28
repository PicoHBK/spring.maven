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

import spring.demo.models.AdminModel;
import spring.demo.models.PrioridadModel;
import spring.demo.models.SocioModel;
import spring.demo.models.UsuarioModels;
import spring.demo.services.AdminService;
import spring.demo.services.PrioridadService;
import spring.demo.services.SocioService;
import spring.demo.services.UsuarioService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    // auto instanciar el servicio
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PrioridadService prioridadService;
    @Autowired
    AdminService adminService;
    @Autowired
    SocioService socioService;

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

    @RequestMapping("/admin")
    public List<AdminModel> getAdmins(){
        return adminService.getAdmins();
    }

    //
   // CARGA UN USUARIO SE TIENE QUE MANDAR UN JSON
   //
    @PostMapping()
    public UsuarioModels guardarUsuario(@RequestBody UsuarioModels usuario){
    
        return this.usuarioService.guardarUsuario(usuario);

    }  
     //
    // CARGA UN ADMIN SE TIENE QUE MANDAR UN JSON ADMIN HEREDA DE USUARIO  
    @PostMapping("/admin")
    public AdminModel guardarUsuario(@RequestBody AdminModel admin){

        return this.adminService.guardarAdmin(admin);
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

    //
    // CARGA UN SOCIO SE TIENE QUE MANDAR UN JSON ADMIN HEREDA DE USUARIO  
    @PostMapping("/socio")
    public SocioModel guardarUsuario(@RequestBody SocioModel socio){

        return this.socioService.guardarSocio(socio);
    }

    //
    // MUESTRA TODOS LOS SOCIOS EN JSON  
    @RequestMapping("/socio")
    public List<SocioModel> getSocios(){
        return socioService.getSocios();
    }

    @GetMapping("/pageable")
    public List<UsuarioModels> obtenerPageable(Pageable pageable){
        return usuarioService.obtenerPorPaginacion(pageable);
    }
}
