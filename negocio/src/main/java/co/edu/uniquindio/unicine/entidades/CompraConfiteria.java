package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CompraConfiteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    @PositiveOrZero
    private int unidades;

    @ManyToOne
    private Compra compra;

    @ManyToOne
    private Confiteria confiteria;

    @Builder
    public CompraConfiteria(double precio, int unidades) {
        this.precio = precio;
        this.unidades = unidades;
    }
}
