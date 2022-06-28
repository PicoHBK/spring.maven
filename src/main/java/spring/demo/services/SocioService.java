package spring.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.models.SocioModel;
import spring.demo.repository.SocioRepository;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;


    public List<SocioModel> getSocios(){
        return (List<SocioModel>) socioRepository.findAll();
    }

    public SocioModel guardarSocio(SocioModel socio){
        return socioRepository.save(socio);
    }
}
