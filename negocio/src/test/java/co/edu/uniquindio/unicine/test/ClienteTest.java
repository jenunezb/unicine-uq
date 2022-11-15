package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import co.edu.uniquindio.unicine.repo.CompraRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private CompraRepo compraRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Cliente cliente = new Cliente("pepito", "pepe@gmail.com", "ruta", "12344");
        Cliente guardado = clienteRepo.save(cliente);
        Assertions.assertNotNull(guardado);
    }
@Test
@Sql("classpath:dataset.sql")
    public void eliminar(){
        Cliente buscado = clienteRepo.findById(1).orElse(null);
        clienteRepo.delete(buscado);
        Assertions.assertNull(clienteRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
       Cliente guardado = clienteRepo.findById(1).orElse(null);
        guardado.setCorreo("pepe@gmail.com");
        Cliente nuevo = clienteRepo.save(guardado);
        Assertions.assertEquals("pepe@gmail.com", nuevo.getCorreo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Cliente> buscado = clienteRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Cliente> lista = clienteRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPorCorreo(){
        Cliente cliente = clienteRepo.findByCorreo("gabriela@gmail.com");
       System.out.println(cliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findByCorreoAndPassword(){
        Cliente cliente = clienteRepo.comprobarAutenticacion("gabriela@gmail.com", "123");
        Assertions.assertNotNull(cliente);
    }

}
