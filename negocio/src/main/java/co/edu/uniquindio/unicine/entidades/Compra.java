package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Compra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(length = 100, nullable = false)
    private String medioPago;

    @Column(nullable = false)
    private LocalDateTime fechaCompra;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "compra")
    private List<Entrada> entrada;

    @Column(nullable = false)
    private double valorTotal;

    @OneToOne(mappedBy = "compra")
    private CuponCliente cupon_cliente;

    @ManyToOne
    private Funcion funcion;

    @OneToMany(mappedBy = "compra")
    private List<CompraConfiteria> compra_confiteria;
}
