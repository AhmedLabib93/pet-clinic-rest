package pet.clinic.rest.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.clinic.rest.entity.Visit;

import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {

    private long id;
    private String name;
    private Date birthDate;
    private long typeId;
    private long ownerId;
    private Set<Visit> visits;
}
