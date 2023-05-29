package pet.clinic.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.clinic.rest.entity.PetType;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
