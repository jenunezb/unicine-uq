package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.repo.TeatroRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeatroTest {

    @Autowired
    private TeatroRepo teatroRepo;
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudadDeTeatroUbicadoAlli(){
        List <Teatro> teatros= teatroRepo.listar("Armenia");
        teatros.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Teatro> lista = teatroRepo.findAll();
        lista.forEach(System.out::println);
    }
}
