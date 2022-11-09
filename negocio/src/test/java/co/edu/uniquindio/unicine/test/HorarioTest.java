package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Horario;
import co.edu.uniquindio.unicine.repo.HorarioRepo;
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
public class HorarioTest {
    @Autowired
    private HorarioRepo horarioRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Horario horario = new Horario();
        Horario guardado = horarioRepo.save(horario);
        Assertions.assertNotNull(guardado);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Horario> lista = horarioRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Horario buscado = horarioRepo.findById(1).orElse(null);
        horarioRepo.delete(buscado);
        Assertions.assertNull(horarioRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Horario guardado = horarioRepo.findById(1).orElse(null);
        guardado.setCodigo(38);
        Horario nuevo = horarioRepo.save(guardado);
        Assertions.assertEquals(3800, nuevo.getCodigo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Horario> buscado = horarioRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

}
