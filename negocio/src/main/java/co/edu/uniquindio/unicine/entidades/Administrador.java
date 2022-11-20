package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Administrador extends Persona implements Serializable {

    @Email
    @Column(nullable = false,length = 100, unique = true)
    String correo;


    public Administrador(Integer cedula, String nombre, String correo) {
        super(cedula, nombre);
        this.correo = correo;
    }
}