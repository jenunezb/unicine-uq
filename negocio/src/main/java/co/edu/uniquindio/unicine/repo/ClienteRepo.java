package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
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

    /*
    Elabore un query que dado el email de un usuario, permita obtener la lista de sus compras. De igual
    forma elabore un método Test que permita probar la consulta.
     */
}


