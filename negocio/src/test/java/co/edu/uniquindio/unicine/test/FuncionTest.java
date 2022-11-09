package co.edu.uniquindio.unicine.test;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.repo.FuncionRepo;
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
public class FuncionTest {
    @Autowired
    private FuncionRepo funcionRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Funcion funcion = new Funcion(3900,null, null, null);
        Funcion guardado = funcionRepo.save(funcion);
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Funcion buscado = funcionRepo.findById(1).orElse(null);
        funcionRepo.delete(buscado);
        Assertions.assertNull(funcionRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Funcion guardado = funcionRepo.findById(1).orElse(null);
        guardado.setPrecio(3800);
        Funcion nuevo = funcionRepo.save(guardado);
        Assertions.assertEquals(3800, nuevo.getPrecio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Funcion> buscado = funcionRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Funcion> lista = funcionRepo.findAll();
        lista.forEach(System.out::println);
    }
}
