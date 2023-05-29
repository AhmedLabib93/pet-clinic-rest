package pet.clinic.rest.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {

    private long id;
    private Date date;
    private String description;
    private long petId;
}
