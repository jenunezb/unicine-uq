package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdministradorServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class DetallePeliculaBean implements Serializable {
    @Autowired
    private AdministradorServicio administradorServicio;

    @Value("#{param['pelicula-id']}")
    private String peliculaCodigo;

    @Getter @Setter
    private Pelicula pelicula;

    @PostConstruct
    public void init(){
        try{
            if(peliculaCodigo!=null && !peliculaCodigo.isEmpty()){
                pelicula = administradorServicio.obtenerPelicula(Integer.parseInt(peliculaCodigo));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
