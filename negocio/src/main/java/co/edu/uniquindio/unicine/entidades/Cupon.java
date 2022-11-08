package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cupon implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String descripcion;
    private String criterio;
    private String descuento;
    private LocalDate vencimiento;

    @OneToMany(mappedBy = "cupon")
    private List<CuponCliente> cupon_cliente;

}
