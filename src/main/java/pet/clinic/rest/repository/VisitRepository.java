package pet.clinic.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.clinic.rest.entity.Visit;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findByPetId(long id);
}
