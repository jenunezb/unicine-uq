package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.repo.EntradaRepo;
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
public class EntradaTest {
    @Autowired
    private EntradaRepo entradaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
       Entrada entrada = new Entrada( 2800, 1, 1);
       Entrada guardado = entradaRepo.save(entrada);
       System.out.println(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Entrada buscado = entradaRepo.findById(1).orElse(null);
        entradaRepo.delete(buscado);
        Assertions.assertNull(entradaRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Entrada guardado = entradaRepo.findById(1).orElse(null);
        guardado.setPrecio(3800);
        Entrada nuevo = entradaRepo.save(guardado);
        Assertions.assertEquals(3800, nuevo.getPrecio());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Entrada> buscado = entradaRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Entrada> lista = entradaRepo.findAll();
        lista.forEach(System.out::println);
    }
}
