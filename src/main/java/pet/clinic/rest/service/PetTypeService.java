package pet.clinic.rest.service;

import pet.clinic.rest.payload.PetDto;
import pet.clinic.rest.payload.PetTypeDto;

import java.util.List;

public interface PetTypeService {


    PetTypeDto addPetType(PetTypeDto petTypeDto);

    PetTypeDto findPetTypeById(long id);

    List<PetTypeDto> findAllPetTypes();

    PetTypeDto updatePetType(PetTypeDto petTypeDto, long id);

    void deletePetType(long id);
}
