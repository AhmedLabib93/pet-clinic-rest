package pet.clinic.rest.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.clinic.rest.entity.Speciality;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VetDto {

    private long id;
    private String firstName;
    private String lastName;
    private Set<Speciality> specialities;
}
