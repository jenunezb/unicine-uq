package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Horario;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {

    @Query("select f from Funcion f where  f.sala.teatro.codigo= :codigoTeatro")
    List<Funcion> listarFuncionesTeatro(Integer codigoTeatro);

    @Query("select f from Funcion f where f.sala.codigo= :codigoSala")
    List<Funcion> listarFuncionesSala(Integer codigoSala);

    @Query("select f from Sala  s join s.funcion f where s.codigo =:codigoSala and f.horario =:horario")
    List<Funcion> obtenerFuncionesSala(Horario horario, Integer codigoSala);

    @Query("select distinct f.pelicula from Funcion f where f.sala.teatro.ciudad.codigo=:codigoCiudad and f.pelicula.estado=:estadoPelicula")
    List<Pelicula> listarPeliculasEstadoCiudad(Integer codigoCiudad, boolean estadoPelicula);

    @Query("select f.pelicula from Funcion f where f.sala.teatro.ciudad.codigo=:codigoCiudad")
    List<Funcion>listarFuncionesCiudad(Integer codigoCiudad);

    @Query("select distinct f.pelicula from Funcion f where f.pelicula.estado=:estadoPelicula")
    List<Pelicula> listarPeliculasEstado( boolean estadoPelicula);
}
