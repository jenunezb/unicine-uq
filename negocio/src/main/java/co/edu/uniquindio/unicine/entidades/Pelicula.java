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
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column( nullable = false)
    private String sinopsis;

    private String urlTrailer;

    private String imagen;

    private String estado;

    private String reparto;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funcion;

}
