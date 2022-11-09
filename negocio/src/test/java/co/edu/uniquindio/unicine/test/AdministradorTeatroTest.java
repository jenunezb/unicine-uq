package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.AdministradorTeatroRepo;
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
public class AdministradorTeatroTest {

    @Autowired
    private AdministradorTeatroRepo administradorRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        AdministradorTeatro administradorTeatro = new AdministradorTeatro(1, "administradorteatro@gmail.com");
        AdministradorTeatro guardado = administradorRepo.save(administradorTeatro);
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        AdministradorTeatro buscado = administradorRepo.findById(1).orElse(null);
        administradorRepo.delete(buscado);
        Assertions.assertNull(administradorRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        AdministradorTeatro buscado = administradorRepo.findById(1).orElse(null);
        buscado.setCorreo("bejarano@gmail.com");
        AdministradorTeatro nuevo = administradorRepo.save(buscado);
        Assertions.assertEquals("bejarano@gmail.com", nuevo.getCorreo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<AdministradorTeatro> buscado = administradorRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<AdministradorTeatro> lista = administradorRepo.findAll();
        lista.forEach(System.out::println);
    }
}
