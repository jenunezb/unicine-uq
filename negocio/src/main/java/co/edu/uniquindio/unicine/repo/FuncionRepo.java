package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.dto.FuncionDTO;
import co.edu.uniquindio.unicine.entidades.Funcion;
import org.hibernate.annotations.SqlFragmentAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {
    /*
  Elabore un query que dado el ID de una función devuelva el nombre de la película que tiene
  asociada. Escriba un método de tipo test para probar dicha consulta.
   */
    @Query("select f.pelicula.nombre from Funcion f where f.codigo=:codigoFuncion")
    String obtenerNombrePelicula(Integer codigoFuncion);

    /*
    Elabore un query que retorne la lista de las funciones de una película. Debe retornar el nombre de
    la película, el estado, la imagen, el número de la sala, la dirección del teatro, la ciudad y el horario.
     */
}
