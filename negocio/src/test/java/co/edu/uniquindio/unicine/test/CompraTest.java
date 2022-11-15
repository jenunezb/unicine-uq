package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.MedioPago;
import co.edu.uniquindio.unicine.repo.CompraRepo;
import co.edu.uniquindio.unicine.entidades.Compra;
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
public class CompraTest {

    @Autowired
    private CompraRepo compraRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Compra compra = new Compra(MedioPago.DAVIPLATA, 78000, null, null, null, null,null);
        Compra guardado = compraRepo.save(compra);
        Assertions.assertNotNull(guardado);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Compra buscado = compraRepo.findById(1).orElse(null);
        compraRepo.delete(buscado);
        Assertions.assertNull(compraRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Compra guardado = compraRepo.findById(1).orElse(null);
        guardado.setCodigo(80);
        Compra nuevo = compraRepo.save(guardado);
        Assertions.assertEquals(80, nuevo.getCodigo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Compra> buscado = compraRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Compra> lista = compraRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarporCorreoEspecifico(){
        List<Compra> listaPorCorreo = compraRepo.listar("kph@gmail.com");
        listaPorCorreo.forEach(System.out::println);
    }
}
