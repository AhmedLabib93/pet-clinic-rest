package pet.clinic.rest.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.clinic.rest.entity.Pet;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDto {

    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String phone;
    private Set<Pet> pets;
}
