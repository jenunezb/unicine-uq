package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @ManyToOne
    private Teatro teatro;

    @ManyToOne
    private DistribucionSillas distribucion_sillas;

    @ToString.Exclude
    @OneToMany(mappedBy = "sala")
    private List<Funcion> funcion;

    @Builder
    public Sala(String nombre, Teatro teatro, DistribucionSillas distribucion_sillas) {
        this.nombre = nombre;
        this.teatro = teatro;
        this.distribucion_sillas = distribucion_sillas;
    }
}
