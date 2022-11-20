package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Pelicula;

import java.util.List;
import java.util.Optional;

public interface ClienteServicio {

    Cliente loguin (String correo, String password) throws Exception;

    Cliente obtenerCliente(Integer codigoCliente) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    boolean validarCorreoRepetido(String correo) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente(Integer codigoCliente) throws Exception;

    List<Cliente> listarClientes();

    List<Compra> listarHistorial(Integer codigoCliente) throws Exception;

    Compra registrarCompra(Compra compra) throws Exception;

    boolean redimirCupon(Integer codigoCupon) throws Exception;

    Optional<Cliente> buscarPorId(Integer cedulaCliente) throws Exception;

    List<Pelicula> listarPeliculas(String nombre) throws Exception;

    boolean cambiarPassword(Integer codigoCliente) throws Exception;
}
