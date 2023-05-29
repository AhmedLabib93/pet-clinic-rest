package pet.clinic.rest.service;

import pet.clinic.rest.payload.PetDto;
import pet.clinic.rest.payload.VetDto;

import java.util.List;

public interface VetService {


    VetDto addVet(VetDto vetDto);

    VetDto findVetById(long id);

    List<VetDto> findAllVets();

    VetDto updateVet(VetDto vetDto, long id);

    void deleteVet(long id);
}
