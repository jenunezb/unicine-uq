package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

    /**
     * Consulta en JPQL
     *
     * @param correo el correo que quiero buscar
     * @return el cliente que buscamos
     */
    Cliente findByCorreo(String correo);

    @Query("select c from Cliente c where c.correo= :correo and c.password= :password")
    Cliente comprobarAutenticacion(String correo, String password);

    Cliente findByCorreoAndPassword(String email, String clave);

    @Query("select c from Cliente c where c.estado= :estado")
    List<Cliente> obtenerPorEstado(boolean estado, Pageable paginador);

}


