package pet.clinic.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "birth_date", columnDefinition = "DATE")
    private Date birthDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Visit> visits = new HashSet<>();
}
