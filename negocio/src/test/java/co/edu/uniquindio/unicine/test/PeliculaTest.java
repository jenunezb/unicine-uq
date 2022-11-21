package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaTest {
    @Autowired
    private PeliculaRepo peliculaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {
        Pelicula pelicula = new Pelicula("Eterno resplandor de una mente sin recuerdo", "sinopsis", "url_trailer",
                "url_imagen", true, "reparto",null);
        Pelicula guardado = peliculaRepo.save(pelicula);
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Pelicula> lista = peliculaRepo.findAll();
        lista.forEach(System.out::println);
    }
}
