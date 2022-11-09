package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.DistribucionSillas;
import co.edu.uniquindio.unicine.repo.DistribucionSillasRepo;
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
public class DistribucionSillaTest {
    @Autowired
    private DistribucionSillasRepo distribucionSillasRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        DistribucionSillas distribucionSillas = new DistribucionSillas("Esquema x ", 50, 50, null,100);
        DistribucionSillas guardado = distribucionSillasRepo.save(distribucionSillas);
        System.out.println(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        DistribucionSillas buscado = distribucionSillasRepo.findById(1).orElse(null);
        distribucionSillasRepo.delete(buscado);
        Assertions.assertNull(distribucionSillasRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        DistribucionSillas guardado = distribucionSillasRepo.findById(1).orElse(null);
        guardado.setCodigo(45);
        DistribucionSillas nuevo = distribucionSillasRepo.save(guardado);
        Assertions.assertEquals(45, nuevo.getCodigo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<DistribucionSillas> buscado = distribucionSillasRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<DistribucionSillas> lista = distribucionSillasRepo.findAll();
        lista.forEach(System.out::println);
    }

}
