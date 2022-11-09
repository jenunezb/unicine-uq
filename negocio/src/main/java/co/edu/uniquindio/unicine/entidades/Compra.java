package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private MedioPago medioPago;

    @Column(nullable = false)
    private LocalDateTime fechaCompra;

    @Positive
    @Column(nullable = false)
    private double valorTotal;

    @ManyToOne
    private Cliente cliente;

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<Entrada> entrada;


    @OneToOne(mappedBy = "compra")
    private CuponCliente cupon_cliente;

    @ManyToOne
    private Funcion funcion;

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<CompraConfiteria> compra_confiteria;

    @Builder

    public Compra(MedioPago medioPago, double valorTotal, Cliente cliente, List<Entrada> entrada, CuponCliente cupon_cliente, Funcion funcion, List<CompraConfiteria> compra_confiteria) {
        this.medioPago = medioPago;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.entrada = entrada;
        this.cupon_cliente = cupon_cliente;
        this.funcion = funcion;
        this.compra_confiteria = compra_confiteria;
        fechaCompra=LocalDateTime.now();
    }
}
