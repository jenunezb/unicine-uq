package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cliente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 150, nullable = false, unique = true)
    @Email
    private String correo;

    private String foto_url;

    @Column(length = 100, nullable = false)
    private String password;

    private String estado;

    /**
     *     @ElementCollection
     *     private Map <String, String> telefono;
     */

    @OneToMany(mappedBy = "cliente")
    private List<CuponCliente> cupon_cliente;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compra;
}
