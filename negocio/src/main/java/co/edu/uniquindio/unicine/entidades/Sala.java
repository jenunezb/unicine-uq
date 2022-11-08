package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Sala implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @ManyToOne
    private Teatro teatro;

    @ManyToOne
    private DistribucionSillas distribucion_sillas;

    @OneToMany(mappedBy = "sala")
    private List<Funcion> funcion;
}
