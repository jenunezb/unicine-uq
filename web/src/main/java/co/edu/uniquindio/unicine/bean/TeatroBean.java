package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import co.edu.uniquindio.unicine.servicios.AdministradorServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class TeatroBean implements Serializable {
    @Getter @Setter
    private Teatro teatro;

    @Getter @Setter
    private List<Teatro> teatros;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<Teatro> teatrosSeleccionados;
    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    @PostConstruct
    public void init(){
        teatro = new Teatro();
        ciudades = administradorServicio.listarCiudades();
        teatros = adminTeatroServicio.listarTeatros();
    }

    public String crearTeatro(){
        try {

            //Esto se borra cuando se implemente la sesión
            AdministradorTeatro administradorTeatro = adminTeatroServicio.obtenerAdminTeatro(1);

            teatro.setAdministrador_teatro(administradorTeatro);
            Teatro registrado = adminTeatroServicio.crearTeatro(teatro);
            teatros.add(registrado);
            return "/admin/teatro_creado?faces-redirect=true";
        }catch (Exception e){
            FacesMessage fm = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
        return "";
    }
}
