package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.dto.PeliculaFuncion;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {

    @Query("select p from Pelicula p where p.nombre like concat('%',:nombre,'%') ")
    List<Pelicula> buscarPelicula(String nombre);

    @Query("select new  co.edu.uniquindio.unicine.dto.PeliculaFuncion(p,f) from Pelicula p left join p.funcion f where " +
            "p.nombre like concat('%',:nombre,'%') ")
    List<PeliculaFuncion> buscarPeliculas(String nombre);

}
