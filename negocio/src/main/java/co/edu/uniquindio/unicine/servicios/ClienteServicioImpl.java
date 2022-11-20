package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.MedioPago;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import co.edu.uniquindio.unicine.repo.CompraRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {


    private final ClienteRepo clienteRepo;
    private final EmailServicio emailServicio;

    public ClienteServicioImpl(ClienteRepo clienteRepo, EmailServicio emailServicio) {

        this.clienteRepo = clienteRepo;
        this.emailServicio = emailServicio;
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
        boolean correoExiste = validarCorreoRepetido(cliente.getCorreo());
        if (correoExiste){
            throw new  Exception("El correo ta está en uso");
        }
        emailServicio.enviarEmail("Registro en Unicine", "Hola debe de ir al siguiente enlace para activar la cuenta", cliente.getCorreo());
        return clienteRepo.save(cliente);
    }

    @Override
    public boolean validarCorreoRepetido(String correo) throws Exception {
        Cliente aComparar = clienteRepo.findByCorreo(correo);
        if(aComparar==null){
            return true;
        }
        String correoAcomparar = aComparar.getCorreo();
        if(correo.equals(correoAcomparar)){
            throw new Exception("El correo ingresado ya fue registrado");
        }
         return true;
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
    public boolean redimirCupon(Integer codigoCupon) {
        return false;
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
    public List<Pelicula> listarPeliculas(String nombre) throws Exception {
        return null;
    }

    @Override
    public boolean cambiarPassword(Integer codigoCliente) throws Exception {
        return false;
    }
}
