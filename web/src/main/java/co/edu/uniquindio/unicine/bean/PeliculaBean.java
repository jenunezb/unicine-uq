package co.edu.uniquindio.unicine.bean;


import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdministradorServicio;
import co.edu.uniquindio.unicine.servicios.AdministradorServicioImpl;
import co.edu.uniquindio.unicine.servicios.CloudinaryServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ViewScoped
public class PeliculaBean implements Serializable {

    @Getter @Setter
    private Pelicula pelicula;

    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private CloudinaryServicio cloudinaryServicio;

    @Getter @Setter
    private List<Genero>generos;



    private Map<String, String> imagenes;

    @PostConstruct
    public void init(){
        pelicula = new Pelicula();
        generos = Arrays.asList(Genero.values());
        imagenes = new HashMap<>();
    }

    public void crearPelicula(){
        try{
            if(!imagenes.isEmpty()){
                pelicula.setEstado(true);
                administradorServicio.crearPelicula(pelicula);
                pelicula.setImagenes(imagenes);
                FacesMessage fm = new FacesMessage( FacesMessage.SEVERITY_INFO, "Alerta", "Película creada correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }else{
                FacesMessage fm = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Alerta", "Es necesario subir al menos una imagen");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }

        }catch (Exception e){
            FacesMessage fm = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }
    public void subirImagenes(FileUploadEvent event) {
        try {
        UploadedFile imagen = event.getFile();
        File imagenFile = convertirUploadedFile(imagen);

            Map resultado =cloudinaryServicio.subirImagen(imagenFile, "peliculas" );
            imagenes.put(resultado.get("public_id").toString(), resultado.get("url").toString());
        }

        catch (Exception e) {
            FacesMessage fm = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

    public File convertirUploadedFile(UploadedFile imagen) throws IOException {
        File file = new File(imagen.getFileName());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getContent());
        fos.close();
        return file;
    }


}
