package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CuponCliente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private String estado;

    @ManyToOne
    private Cupon cupon;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Compra compra;
}
