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
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column( nullable = false)
    private String sinopsis;

    private String urlTrailer;

    private String imagen;

    private String estado;

    private String reparto;

    private Genero genero;

    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funcion;

}
