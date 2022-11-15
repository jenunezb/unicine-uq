package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.MedioPago;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import co.edu.uniquindio.unicine.repo.CompraRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {


    private ClienteRepo clienteRepo;
    private CompraRepo compraRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
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
    public Cliente registrarCliente(Cliente cliente)throws Exception {

        validarCorreoRepetido(cliente.getCorreo());

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
    public Compra registrarCompra(Compra compra) {
        return compraRepo.save(compra);
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
}
