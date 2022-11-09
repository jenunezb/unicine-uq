package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CuponCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String estado;

    @ManyToOne
    private Cupon cupon;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Compra compra;

    public CuponCliente(String estado, Cupon cupon, Cliente cliente, Compra compra) {
        this.estado = estado;
        this.cupon = cupon;
        this.cliente = cliente;
        this.compra = compra;
    }
}
