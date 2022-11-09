package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {
    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar(){

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3244545");
        Cliente cliente = new Cliente("pepito", "pepe@gmail.com", "ruta", "12344");

        Cliente guardado = clienteRepo.save(cliente);
        Assertions.assertNotNull(guardado);
    }
@Test
    public void eliminar(){

        Cliente cliente = new Cliente("pepito", "pepe@gmail.com", "ruta", "12344");
        cliente.setCedula(1);

        Cliente guardado = clienteRepo.save(cliente);

        clienteRepo.delete(guardado);

        Optional<Cliente> buscado = clienteRepo.findById(1);

        Assertions.assertNull(buscado.orElse(null));
    }

    @Test
    public void actualizar(){

        Cliente cliente = new Cliente("pepito", "pepe@gmail.com", "ruta", "12344");
        cliente.setCedula(1);

        Cliente guardado = clienteRepo.save(cliente);

        guardado.setCorreo("pepe_nuevo@gmail.com");

        Cliente nuevo = clienteRepo.save(guardado);

        Assertions.assertEquals("pepe_nuevo@gmail.com", nuevo.getCorreo());
    }

    @Test
    public void obtener(){
        Cliente cliente = new Cliente("pepito", "pepe@gmail.com", "ruta", "12344");

        Cliente guardado = clienteRepo.save(cliente);
        System.out.println(guardado);

        Optional<Cliente> buscado = clienteRepo.findById(16);

       System.out.println(buscado.orElse(null));

    }

    @Test
    public void listar(){

        Cliente cliente = new Cliente("pepito", "pepe@gmail.com", "ruta", "12344");

        Cliente guardado = clienteRepo.save(cliente);

        clienteRepo.save(cliente);

        List<Cliente> lista = clienteRepo.findAll();

        System.out.println(lista);
    }
}
