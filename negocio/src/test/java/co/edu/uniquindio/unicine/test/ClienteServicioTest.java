package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest(){
        Cliente cliente = Cliente.builder().nombre("Julian Esteban").password("123").correo("julian1@gmail.com").foto_url("urlfoto").cedula(1).build();
        try {
            validarClienteRepetidoTest();
            Cliente nuevo = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(nuevo);
            listarClientesTest();
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientesTest(){
        List<Cliente> lista = clienteServicio.listarClientes();
        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void validarClienteRepetidoTest(){
      String correoEnviado = "julian1@gmail.com";
        try {
            clienteServicio.validarCorreoRepetido(correoEnviado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void modificarClienteTest(){
        Cliente cliente = Cliente.builder().nombre("Julian Esteban").password("123").correo("julian@gmail.com").foto_url("urlfoto").cedula(9).build();
        try {
            clienteServicio.actualizarCliente(cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest(){
        Cliente cliente = Cliente.builder().nombre("Julian Esteban").password("123").correo("julian@gmail.com").foto_url("urlfoto").cedula(9).build();
        try {
            clienteServicio.eliminarCliente(cliente.getCedula());
            Assertions.assertNull(cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarClienteIdTest(){
        try {
           Optional<Cliente> cliente = clienteServicio.buscarPorId(1);
           Assertions.assertNotNull(cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCompraTest(){
        Cliente cliente = Cliente.builder().nombre("Julian Esteban").password("123").correo("julian2@gmail.com").foto_url("urlfoto").cedula(1094927538).build();

      Compra compra = Compra.builder().medioPago(MedioPago.NEQUI).valorTotal(2800).cliente(cliente).entrada().cupon_cliente().funcion().compra_confiteria().build();

        try {
            Compra nueva = clienteServicio.registrarCompra(compra);
            System.out.println(nueva);
            Assertions.assertNotNull(nueva);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        */
}
