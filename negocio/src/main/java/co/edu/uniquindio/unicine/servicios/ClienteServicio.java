package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

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

    CuponCliente crearCuponCliente(Integer codigoCupon) throws Exception;

    Optional<Cliente> buscarPorId(Integer cedulaCliente) throws Exception;

    List<Pelicula> listarPeliculas(String nombre) throws Exception;

    boolean cambiarPassword(Integer codigoCliente) throws Exception;

    List<Funcion> listarPorCiudad(Integer codigoCiudad)throws Exception;

    List<Funcion> listarPorTeatro(Integer codigoTeatro) throws Exception;

    List<CuponCliente> listaCuponesCliente(Integer codigoCliente)throws Exception;

    List<Pelicula> listarPorestadoCiudad(Integer codigoCiudad, boolean estado) throws Exception;

    List<Pelicula> listarPorestado( boolean estado) throws Exception;
}
