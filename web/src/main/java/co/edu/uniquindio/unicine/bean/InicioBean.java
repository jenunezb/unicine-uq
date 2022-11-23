package co.edu.uniquindio.unicine.bean;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdministradorServicio;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private AdministradorServicio administradorServicio;

    @Getter @Setter
    private List<Pelicula> peliculasCartelera;

    @Getter @Setter
    private List<Pelicula> peliculasProximas;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private Ciudad ciudad;

    @Getter @Setter
    private List<String> imagenes;

    @PostConstruct
    public void init(){
        try {
            imagenes = new ArrayList<>();
            imagenes.add("fd");
            imagenes.add("gadg");
            imagenes.add("gdaga");
            peliculasCartelera = clienteServicio.listarPorestado(true);
            peliculasProximas = clienteServicio.listarPorestado( false);
            ciudades=administradorServicio.listarCiudades();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void elegirCiudad(){
        try {
            if(ciudad!=null){
                peliculasCartelera = clienteServicio.listarPorestadoCiudad(ciudad.getCodigo(), true);
                peliculasProximas = clienteServicio.listarPorestadoCiudad(ciudad.getCodigo(), false);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    }

