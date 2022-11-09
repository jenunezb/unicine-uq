package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.repo.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {
    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Ciudad ciudad = new Ciudad("Armenia");
        Ciudad guardada = ciudadRepo.save(ciudad);
        Assertions.assertNotNull(guardada);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Ciudad buscada = ciudadRepo.findById(1).orElse(null);
        ciudadRepo.delete(buscada);
        Assertions.assertNull(ciudadRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Ciudad guardada = ciudadRepo.findById(1).orElse(null);
        guardada.setNombre("Pereira");
        Ciudad nuevo = ciudadRepo.save(guardada);
        Assertions.assertEquals("Pereira", nuevo.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Ciudad> buscada = ciudadRepo.findById(1);
        Assertions.assertNotNull(buscada.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Ciudad> lista = ciudadRepo.findAll();
        lista.forEach(System.out::println);
    }
}
