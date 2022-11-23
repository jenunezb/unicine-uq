package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
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

    @Lob
    @Column( nullable = false)
    private String sinopsis;

    private String urlTrailer;

    @ElementCollection
    @NonNull
    private Map<String,String> imagenes;

    @Column(nullable = false)
    private boolean estado;

    @Lob
    @Column(nullable = false)
    private String reparto;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @Column(nullable = false)
    private List<Genero> generos;

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funcion;

    @Builder
    public Pelicula(String nombre, String sinopsis, String urlTrailer, boolean estado, String reparto, List<Genero> generos) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.urlTrailer = urlTrailer;
        this.estado = estado;
        this.reparto = reparto;
        this.generos = generos;
    }

    public String getImagenPrincipal(){
       if(!imagenes.isEmpty()){
           String primera = imagenes.keySet().toArray()[0].toString();
           return imagenes.get(primera);
       }
       return "";
    }

}
