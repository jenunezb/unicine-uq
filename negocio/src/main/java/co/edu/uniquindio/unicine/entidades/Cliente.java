package co.edu.uniquindio.unicine.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Integer cedula;

    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String nombre;

    @NotNull
    @Column(length = 150, nullable = false, unique = true)
    @Length(max = 150)
    @Email
    private String correo;

    @Column(nullable = false)
    private String foto_url="";

    @ToString.Exclude
    @Column(length = 100, nullable = false)
    @Length(max = 100)
    private String password;

    @Column(nullable = false)
    private boolean estado=false;

    @ElementCollection
    private Map <String, String> telefono;


    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<CuponCliente> cupon_cliente;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compra;

    @Builder
    public Cliente( String nombre, String correo, String foto_url, String password, Integer cedula) {
        this.nombre = nombre;
        this.correo = correo;
        this.foto_url = foto_url;
        this.password = password;
        this.estado = false;
        this.cedula = cedula;
    }
}
