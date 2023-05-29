package pet.clinic.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.clinic.rest.entity.Vet;

public interface VetRepository extends JpaRepository<Vet, Long> {

}
