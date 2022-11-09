package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class AdministradorTeatro implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer cedula;

    @Email
    @Column(nullable = false,length = 100, unique = true)
    String correo;


    @ToString.Exclude
    @OneToMany(mappedBy = "administrador_teatro")
    private List<Teatro> teatro;

    @Builder
    public AdministradorTeatro(Integer cedula, String correo) {
        this.cedula = cedula;
        this.correo = correo;
    }
}
