package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface EntradaRepo extends JpaRepository<Entrada, CriteriaBuilder.In> {
}