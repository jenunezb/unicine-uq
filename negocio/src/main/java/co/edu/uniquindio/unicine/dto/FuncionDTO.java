package co.edu.uniquindio.unicine.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class FuncionDTO {
    private String nombrePelicula;
    private String estadoPelicula;
    private String rutaImagen;
    private Integer numeroSala;
    private String direccionTeatro;
    private String nombreCiudad;
}

