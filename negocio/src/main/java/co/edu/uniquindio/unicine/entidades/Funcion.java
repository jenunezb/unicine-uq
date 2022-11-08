package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Funcion implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private double precio;

}
