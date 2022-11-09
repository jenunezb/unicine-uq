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
public class Funcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;
    @Column(nullable = false)
    private double precio;

    @ToString.Exclude
    @OneToMany(mappedBy = "funcion")
    private List<Compra> compra;

    @ManyToOne
    private Sala sala;

    @ManyToOne
    private Horario horario;

    @ManyToOne
    private Pelicula pelicula;

    @Builder
    public Funcion(double precio,  Sala sala, Horario horario, Pelicula pelicula) {
        this.precio = precio;
        this.sala = sala;
        this.horario = horario;
        this.pelicula = pelicula;
    }
}
