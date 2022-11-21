package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {
    /*
  Elabore un query que dado el ID de una función devuelva el nombre de la película que tiene
  asociada. Escriba un método de tipo test para probar dicha consulta.
   */

    /*
    Elabore un query que retorne la lista de las funciones de una película. Debe retornar el nombre de
    la película, el estado, la imagen, el número de la sala, la dirección del teatro, la ciudad y el horario.
     */
}
