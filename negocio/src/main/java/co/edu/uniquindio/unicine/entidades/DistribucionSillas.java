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
public class DistribucionSillas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 100, nullable = false)
    private String esquema;

    @Column(nullable = false)
    private int totalSillas;

    @Column(nullable = false)
    private int filas;

    @Column(nullable = false)
    private int columnas;

    @OneToMany(mappedBy = "distribucion_sillas")
    private List<Sala> salas;
}
