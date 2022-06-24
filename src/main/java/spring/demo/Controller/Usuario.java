package spring.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usuario {
    @RequestMapping(value ="/prueba")
    public String prueba(){
        return "Hola mundooooooooo";
    }
}
