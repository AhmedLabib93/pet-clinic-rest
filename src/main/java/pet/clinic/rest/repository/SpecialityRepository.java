package pet.clinic.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.clinic.rest.entity.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
