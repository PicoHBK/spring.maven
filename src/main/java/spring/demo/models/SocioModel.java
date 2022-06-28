package spring.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@Table(name = "socio")
@PrimaryKeyJoinColumn(name = "usuarioId")
public class SocioModel extends UsuarioModels{

   @Column(columnDefinition = "boolean default false", nullable = false) 
    boolean activo;

public boolean isActivo() {
    return activo;
}

public void setActivo(boolean activo) {
    this.activo = activo;
}
    
}


