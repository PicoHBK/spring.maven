package spring.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.models.PagoModel;
import spring.demo.repository.PagoRepository;



@Service
public class PagoService{
    @Autowired
    PagoRepository pagoRepository;


    public List<PagoModel> getPagos(){
        return (List<PagoModel>) pagoRepository.findAll();
    }

    public PagoModel guardarPago(PagoModel pago){
        return pagoRepository.save(pago);
    }
    
}
