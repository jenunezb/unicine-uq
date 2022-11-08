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
public class Teatro implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

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
}
