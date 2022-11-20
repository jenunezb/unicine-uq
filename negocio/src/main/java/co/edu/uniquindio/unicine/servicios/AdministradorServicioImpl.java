package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

  //  private final AdministradorTeatro administradorTeatro;
    private final AdministradorRepo administradorRepo;
    private final PeliculaRepo peliculaRepo;
    private final CuponRepo cuponRepo;
    private final CiudadRepo ciudadRepo;

    @Autowired
    public AdministradorServicioImpl(AdministradorRepo administradorRepo, PeliculaRepo peliculaRepo, CuponRepo cuponRepo, CiudadRepo ciudadRepo, ConfiteriaRepo confiteriaRepo) {
        this.administradorRepo = administradorRepo;
        this.peliculaRepo = peliculaRepo;
        this.cuponRepo = cuponRepo;
        this.ciudadRepo = ciudadRepo;
        this.confiteriaRepo = confiteriaRepo;
    }

    private final ConfiteriaRepo confiteriaRepo;

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) {
       return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        Optional<Ciudad> ciudad = Optional.ofNullable(ciudadRepo.findByCodigo(codigo));
        if(ciudad.isEmpty()){
            throw new Exception("No hay una ciudad con ese código");
        }
        return ciudad.get();
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return null;
    }

    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) throws Exception {
        return null;
    }

    @Override
    public void eliminarPelicula(Integer codigo) throws Exception {

    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return null;
    }

    @Override
    public Pelicula obtenerPelicula(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Cupon crearCupon() {
        return null;
    }

    @Override
    public Cupon actualizarCupon() throws Exception {
        return null;
    }

    @Override
    public void eliminarCupon(Integer codigo) throws Exception {

    }

    @Override
    public List<Cupon> listarCupones() {
        return null;
    }

    @Override
    public Cupon obtenerCupon(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Confiteria crearConfiteria(Confiteria confiteria) {
        return null;
    }

    @Override
    public Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception {
        return null;
    }

    @Override
    public void eliminarConfiteria(Integer codigo) throws Exception {

    }

    @Override
    public List<Confiteria> listarConfiteria() {
        return null;
    }

    @Override
    public Confiteria obtenerConfiteria(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public AdministradorTeatro crearAdminTeatro(AdministradorTeatro administradorTeatro) {
        return null;
    }

    @Override
    public AdministradorTeatro actualizarAdminTeatro(AdministradorTeatro administradorTeatro) throws Exception {
        return null;
    }

    @Override
    public void eliminarAdminTeatro(Integer codigo) throws Exception {

    }

    @Override
    public List<AdministradorTeatro> listarAdminsTeatros() {
        return null;
    }

    @Override
    public AdministradorTeatro obtenerAdminTeatro(Integer codigo) throws Exception {
        return null;
    }
}
