package pet.clinic.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.clinic.rest.entity.Owner;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findByLastName(String lastName);

}
