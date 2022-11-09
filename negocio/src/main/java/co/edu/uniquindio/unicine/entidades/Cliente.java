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
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cliente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cedula;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 150, nullable = false, unique = true)
    @Email
    private String correo;

    private String foto_url;

    @Column(length = 100, nullable = false)
    private String password;

    private boolean estado;

    /**
     *     @ElementCollection
     *     private Map <String, String> telefono;
     */

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<CuponCliente> cupon_cliente;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compra;

    public Cliente( String nombre, String correo, String foto_url, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.foto_url = foto_url;
        this.password = password;
        this.estado = false;
    }
}
