package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.repo.CuponRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CuponTest {
    @Autowired
    private CuponRepo cuponRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Cupon cupon = new Cupon(" descripcion del cupon","el criterio x", 0.5, LocalDate.of(2022,05,19),null );
        Cupon guardado = cuponRepo.save(cupon);
        System.out.println(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Cupon buscado = cuponRepo.findById(1).orElse(null);
        cuponRepo.delete(buscado);
        Assertions.assertNull(cuponRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Cupon guardado = cuponRepo.findById(1).orElse(null);
        guardado.setDescuento(0.6);
        Cupon nuevo = cuponRepo.save(guardado);
        Assertions.assertEquals(0.6, nuevo.getDescuento());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Cupon> buscado = cuponRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Cupon> lista = cuponRepo.findAll();
        lista.forEach(System.out::println);
    }
}
