package pet.clinic.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.clinic.rest.entity.Pet;
import pet.clinic.rest.entity.PetType;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
