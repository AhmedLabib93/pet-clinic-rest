package pet.clinic.rest.service;

import pet.clinic.rest.payload.PetDto;
import pet.clinic.rest.payload.PetTypeDto;

import java.util.List;

public interface PetService {

    PetDto addPet(PetDto petDto);

    PetDto findPetById(long id);

    List<PetDto> findAllPets();

    PetDto updatePet(PetDto petDto, long id);

    void deletePet(long id);
}
