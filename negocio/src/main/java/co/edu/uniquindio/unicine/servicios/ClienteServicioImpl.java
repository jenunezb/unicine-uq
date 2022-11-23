package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import co.edu.uniquindio.unicine.repo.CuponRepo;
import co.edu.uniquindio.unicine.repo.FuncionRepo;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {


    private final ClienteRepo clienteRepo;
    private final EmailServicio emailServicio;
    private final PeliculaRepo peliculaRepo;
    private final FuncionRepo funcionRepo;
    private final CuponRepo cuponRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo, EmailServicio emailServicio, PeliculaRepo peliculaRepo, FuncionRepo funcionRepo,CuponRepo cuponRepo) {

        this.clienteRepo = clienteRepo;
        this.emailServicio = emailServicio;
        this.peliculaRepo = peliculaRepo;
        this.funcionRepo = funcionRepo;
        this.cuponRepo =cuponRepo;

    }

    @Override
    public Cliente loguin(String correo, String password) throws Exception{
        Cliente cliente = clienteRepo.comprobarAutenticacion(correo,password);
        if(cliente==null){
            throw new Exception("Los datos ingresados son incorrectos");
        }
        return cliente;
    }

    @Override
    public Cliente obtenerCliente(Integer codigoCliente) throws Exception {
        Optional<Cliente> guardado = clienteRepo.findById(codigoCliente);

        if(guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        return guardado.get();
    }

    @Override
    public Cliente registrarCliente(Cliente cliente)throws Exception {

        validarCorreoRepetido(cliente.getCorreo());

        if(clienteRepo.findById(cliente.getCedula()).isEmpty()){
            emailServicio.enviarEmail("Registro en Unicine", "Hola debe de ir al siguiente enlace para activar la cuenta", cliente.getCorreo());
            return clienteRepo.save(cliente);
        }
            throw new Exception("El cliente ya fue registrado con anterioridad");
    }

    @Override
    public boolean validarCorreoRepetido(String correo) throws Exception {
        Cliente aComparar = clienteRepo.findByCorreo(correo);
        if(aComparar==null){
            return true;
        }
            throw new Exception("El correo ya está en uso");
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception{

        Optional<Cliente> guardado = clienteRepo.findById(cliente.getCedula());
        if(guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer codigoCliente) throws Exception{
        Optional<Cliente> guardado = clienteRepo.findById(codigoCliente);
        if(guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        clienteRepo.delete(guardado.get());
    }

    @Override
    public List<Cliente> listarClientes() {

        return clienteRepo.findAll();
    }

    @Override
    public List<Compra> listarHistorial(Integer codigoCliente) {
        return null;
    }

    @Override
    public Compra registrarCompra(Compra compra) throws  Exception{
 /*
 TODO implementar todo
  */
        emailServicio.enviarEmail("Se ha realizado una compra", "Hola ha comprado X entradas" +
                "para ver la película X .....", compra.getCliente().getCorreo());
        return null;
    }

    @Override
    public  CuponCliente crearCuponCliente(Integer codigoCupon) throws  Exception{

        CuponCliente cupon = cuponRepo.findById(codigoCupon).orElse(null);

        if(cupon==null){
            throw new Exception("El cupón no existe");
        }
        //Se crea cualquier código para enviarlo al usuario
        //String codigoCuponGenerado = " "+obtenerLetraAleatoria()+obtenerFechaMili()+obtenerLetraAleatoria();
    return cupon;
    }

    @Override
    public Optional<Cliente> buscarPorId(Integer cedulaCliente) throws Exception {
        Optional<Cliente> guardado = clienteRepo.findById(cedulaCliente);
        if(guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        return guardado;
    }


    @Override
    public boolean cambiarPassword(Integer codigoCliente) throws Exception {
        return false;
    }

    @Override
    public List<Pelicula> listarPorestadoCiudad(Integer codigoCiudad, boolean estadoPelicula) throws Exception{
       return funcionRepo.listarPeliculasEstadoCiudad(codigoCiudad,estadoPelicula);
    }

    @Override
    public List<Pelicula> listarPorestado(boolean estado) throws Exception {
        return funcionRepo.listarPeliculasEstado(estado);
    }

    @Override
    public List<Funcion> listarPorCiudad(Integer codigoCiudad) throws Exception{
            return funcionRepo.listarFuncionesCiudad(codigoCiudad);
    }

    @Override
    public List<Funcion> listarPorTeatro(Integer codigoTeatro) throws Exception {
        return funcionRepo.listarFuncionesTeatro(codigoTeatro);
    }

    @Override
    public List<CuponCliente> listaCuponesCliente(Integer codigoCliente) throws Exception {
        Cliente guardado = clienteRepo.findById(codigoCliente).orElse(null);
        if(guardado==null){
            throw new Exception("El cliente no existe");
        }
        return cuponRepo.listarCuponesCliente(codigoCliente);
    }


    @Override
    public List<Pelicula> listarPeliculas(String nombre){
        List<Pelicula> guardada= peliculaRepo.buscarPelicula(nombre);
        return guardada;
    }

}
