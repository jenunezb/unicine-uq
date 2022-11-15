package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer cedula;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Builder
    public Persona(Integer cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
}
