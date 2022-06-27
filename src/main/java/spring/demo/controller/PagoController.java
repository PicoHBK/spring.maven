package spring.demo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.demo.models.PagoModel;
import spring.demo.services.PagoService;

@RestController
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    PagoService pagoService;
    
    @GetMapping()
    public List<PagoModel> getPagos(){
        return pagoService.getPagos();
    }

    @PostMapping()
    public PagoModel guardarPago(@RequestBody PagoModel pago){
        LocalDate fecha = pago.getFecha();
        fecha =fecha.minusMonths(1);
        pago.setFecha(fecha);
        return pagoService.guardarPago(pago);
    }

}
