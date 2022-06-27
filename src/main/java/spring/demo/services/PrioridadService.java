package spring.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.models.PrioridadModel;
import spring.demo.repository.PrioridadRepository;

@Service
public class PrioridadService {

    @Autowired
    private PrioridadRepository prioridadRepository;


    public List<PrioridadModel> getPrioridades() {
        return (List<PrioridadModel>) prioridadRepository.findAll();
    }

    public PrioridadModel guardarPrioridad(PrioridadModel prioridad) {
        return prioridadRepository.save(prioridad);
    }
}
