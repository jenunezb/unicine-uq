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
public class Teatro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 100, nullable = false)
    private String direccion;

    @Column(length = 10, nullable = false)
    private String telefono;


      @ManyToOne
         private AdministradorTeatro administrador_teatro;

      @ManyToOne
        private Ciudad ciudad;

      @OneToMany(mappedBy = "teatro")
        private List<Sala> sala;

      @Builder
         public Teatro(String direccion, String telefono, AdministradorTeatro administrador_teatro, Ciudad ciudad) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.administrador_teatro = administrador_teatro;
        this.ciudad = ciudad;
    }
}
