package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminTeatroServivioImpl implements AdminTeatroServicio{

    private final HorarioRepo horarioRepo;
    private final FuncionRepo funcionRepo;
    private final SalaRepo salaRepo;
    private final TeatroRepo teatroRepo;
    private final AdministradorTeatroRepo administradorTeatroRepo;

    public AdminTeatroServivioImpl(HorarioRepo horarioRepo, FuncionRepo funcionRepo, SalaRepo salaRepo, TeatroRepo teatroRepo, AdministradorTeatroRepo administradorTeatroRepo) {
        this.horarioRepo = horarioRepo;
        this.funcionRepo = funcionRepo;
        this.salaRepo = salaRepo;
        this.teatroRepo = teatroRepo;
        this.administradorTeatroRepo = administradorTeatroRepo;
    }

    @Override
    public Horario crearHorario(Horario horario) {
        return null;
    }

    @Override
    public List<Horario> listarHorarios() {
        return null;
    }

    @Override
    public Horario obtenerHorario(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public void eliminarHorario(Integer codigo) throws Exception {

    }

    @Override
    public Funcion crearFuncion(Funcion funcion) throws Exception {
        return null;
    }

    @Override
    public List<Funcion> listarFunciones() {
        return null;
    }

    @Override
    public Funcion actualizarFuncion(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public void eliminarFuncion(Integer codigo) throws Exception {

    }

    @Override
    public Funcion obtenerFuncion(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Sala crearSala(Sala sala) throws Exception {
        return null;
    }

    @Override
    public Sala actualizarSala(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public void eliminarSala(Integer codigo) throws Exception {

    }

    @Override
    public List<Sala> listarSalas() {
        return null;
    }

    @Override
    public Sala obtenerSala(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Teatro crearTeatro(Teatro teatro) {

        return teatroRepo.save(teatro);

    }

    @Override
    public Teatro actualizarTeatro(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public void eliminarTeatro(Integer codigo) throws Exception {

    }

    @Override
    public List<Teatro> listarTeatros() {
        return teatroRepo.findAll();
    }

    @Override
    public AdministradorTeatro obtenerAdminTeatro(Integer codigo) {
        return administradorTeatroRepo.getById(codigo);
    }

}
