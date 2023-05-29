package pet.clinic.rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="vet_specialties",
        joinColumns = @JoinColumn(name="vet_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="speciality_id", referencedColumnName = "id"))
    private Set<Speciality> specialities = new HashSet<>();
}
