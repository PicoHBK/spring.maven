package spring.demo.models;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "usuario")
public class UsuarioModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String name;
    private String lastName;
    private long telefono;
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPrioridad")
    PrioridadModel idPrioridad;

    @OneToOne
    @JoinColumn(name = "idPago")
    PagoModel idPago;


    


    
    public PagoModel getIdPago() {
        return idPago;
    }
    public void setIdPago(PagoModel idPago) {
        this.idPago = idPago;
    }
    //@JsonIgnoreProperties(value = {"usuarios", "idPrioridad"})
    public PrioridadModel getIdPrioridad() {
        return idPrioridad;
    }
    public void setIdPrioridad(PrioridadModel idPrioridad) {
        this.idPrioridad = idPrioridad;
    }
    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    



    
    
}
