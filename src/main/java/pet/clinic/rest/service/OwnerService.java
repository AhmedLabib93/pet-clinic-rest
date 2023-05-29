package pet.clinic.rest.service;

import pet.clinic.rest.payload.OwnerDto;

import java.util.List;

public interface OwnerService {
    OwnerDto addOwner(OwnerDto ownerDto);

    OwnerDto findOwnerById(long id);

    List<OwnerDto> findOwnersByLastName(String lastName);

    List<OwnerDto> findAllOwners();


    OwnerDto updateOwner(OwnerDto ownerDto, long id);

    void deleteOwner(long id);

}
