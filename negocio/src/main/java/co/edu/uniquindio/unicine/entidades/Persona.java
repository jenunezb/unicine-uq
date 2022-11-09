package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cedula;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Builder
    public Persona(Integer cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
}
