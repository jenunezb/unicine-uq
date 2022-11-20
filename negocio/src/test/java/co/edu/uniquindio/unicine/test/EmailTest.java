package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.servicios.EmailServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;


@SpringBootTest
@Transactional
public class EmailTest {

    @Autowired
    private EmailServicio emailServicio;

    @Test
    public void enviarCorreoTest(){
        emailServicio.enviarEmail("prueba de que te amo", "Si te llega este mensaje, felicidades si te amo y esta prueba me salió a la primera", "juesnube@gmail.com");
    }
}
