package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Funcion;
import org.hibernate.annotations.SqlFragmentAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {
    /*
  Elabore un query que dado el ID de una función devuelva el nombre de la película que tiene
  asociada. Escriba un método de tipo test para probar dicha consulta.
   */
    @Query("select f.pelicula.nombre from Funcion f where f.codigo=:codigoFuncion")
    String obtenerNombrePelicula(Integer codigoFuncion);
}
