package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

public interface AdminTeatroServicio {

    Horario crearHorario(Horario horario);

    List<Horario> listarHorarios();

    Horario obtenerHorario(Integer codigo) throws Exception;

    void eliminarHorario(Integer codigo) throws Exception;

    Funcion crearFuncion(Funcion funcion) throws Exception;

    List<Funcion> listarFunciones();

    Funcion actualizarFuncion(Integer codigo) throws Exception;

    void eliminarFuncion(Integer codigo) throws Exception;

    Funcion obtenerFuncion(Integer codigo) throws Exception;

    Sala crearSala(Sala sala) throws Exception;

    Sala actualizarSala(Integer codigo) throws Exception;

    void eliminarSala(Integer codigo) throws Exception;

    List<Sala> listarSalas();

    Sala obtenerSala(Integer codigo) throws Exception;

    Teatro crearTeatro(Teatro teatro);

    Teatro actualizarTeatro(Integer codigo) throws Exception;

    void eliminarTeatro(Integer codigo) throws Exception;

    List<Teatro> listarTeatros();

    AdministradorTeatro obtenerAdminTeatro( Integer codigo);

}
