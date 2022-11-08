package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String descripcion;

    private String criterio;

    @Positive
    @Column(nullable = false)
    private String descuento;

    @Column(nullable = false)
    private LocalDate vencimiento;

    @OneToMany(mappedBy = "cupon")
    private List<CuponCliente> cupon_cliente;

    @Builder

    public Cupon(String descripcion, String criterio, String descuento, LocalDate vencimiento, List<CuponCliente> cupon_cliente) {
        this.descripcion = descripcion;
        this.criterio = criterio;
        this.descuento = descuento;
        this.vencimiento = vencimiento;
        this.cupon_cliente = cupon_cliente;
    }
}
