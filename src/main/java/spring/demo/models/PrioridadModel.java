package spring.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "prioridad")
public class PrioridadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idPrioridad;
    @Column(unique = true, nullable = false)
    String tipo;
    @OneToMany(mappedBy = "idPrioridad")
    @JsonIgnore
    private List<UsuarioModels> usuarios;
    



    

   
    public List<UsuarioModels> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<UsuarioModels> usuarios) {
        this.usuarios = usuarios;
    }
    public long getIdPrioridad() {
        return idPrioridad;
    }
    public void setIdPrioridad(long idPrioridad) {
        this.idPrioridad = idPrioridad;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

