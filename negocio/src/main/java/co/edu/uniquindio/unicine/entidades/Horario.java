package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private LocalDate dia;

    @Column(nullable = false)
    private LocalDate hora;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fin;

    @ToString.Exclude
    @OneToMany(mappedBy = "horario")
    private List<Funcion> funcion;

    @Builder
    public Horario(LocalDate dia, LocalDate hora, LocalDateTime inicio, LocalDateTime fin) {
        this.dia = dia;
        this.hora = hora;
        this.inicio = inicio;
        this.fin = fin;
    }
}
