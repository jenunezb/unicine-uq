package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeatroRepo extends JpaRepository<Teatro, Integer> {
    /*
    Elabore un query que dado el nombre de una ciudad devuelva los Teatros que están ubicados allí.
    Escriba un método de tipo test para probar dicha consulta.
     */

    @Query("select t from Teatro t where t.ciudad.nombre=:nombreCiudad")
    List <Teatro> listar(String nombreCiudad);
}