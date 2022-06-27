package spring.demo.models;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
;

@Entity
@Table(name = "pago")
public class PagoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdPago;
    LocalDate fecha;

    @OneToOne(mappedBy = "idPago")
    @JsonIgnore
    UsuarioModels usuario;



    

    public UsuarioModels getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioModels usuario) {
        this.usuario = usuario;
    }
    public long getIdPago() {
        return IdPago;
    }
    public void setIdPago(long idPago) {
        IdPago = idPago;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    

}


