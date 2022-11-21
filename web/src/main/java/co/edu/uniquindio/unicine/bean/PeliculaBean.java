package co.edu.uniquindio.unicine.bean;


import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdministradorServicio;
import co.edu.uniquindio.unicine.servicios.AdministradorServicioImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class PeliculaBean implements Serializable {

    @Getter @Setter
    private Pelicula pelicula;

    @Autowired
    private AdministradorServicio administradorServicio;

    @PostConstruct
    public void init(){
        pelicula = new Pelicula();
    }

    public void crearPelicula(){
        try{
            pelicula.setEstado(true);
            administradorServicio.crearPelicula(pelicula);

            FacesMessage fm = new FacesMessage( FacesMessage.SEVERITY_INFO, "Alerta", "Se ha creado la película correctamente");
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);

        }catch (Exception e){
            FacesMessage fm = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }

    }
}
