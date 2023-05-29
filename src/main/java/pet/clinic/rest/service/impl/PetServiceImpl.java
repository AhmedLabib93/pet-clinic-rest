package pet.clinic.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.clinic.rest.entity.Owner;
import pet.clinic.rest.entity.Pet;
import pet.clinic.rest.entity.PetType;
import pet.clinic.rest.exception.ResourceNotFound;
import pet.clinic.rest.payload.PetDto;
import pet.clinic.rest.repository.OwnerRepository;
import pet.clinic.rest.repository.PetRepository;
import pet.clinic.rest.repository.PetTypeRepository;
import pet.clinic.rest.service.PetService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {


    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetTypeRepository petTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PetDto addPet(PetDto petDto) {
        Pet pet = modelMapper.map(petDto, Pet.class);
        Owner owner = ownerRepository.findById(petDto.getOwnerId()).orElseThrow(()
                -> new ResourceNotFound("Owner not found with id " + petDto.getOwnerId()));
        PetType type = petTypeRepository.findById(petDto.getTypeId()).orElseThrow(()
                -> new ResourceNotFound("PetType not found with id " + petDto.getTypeId()));

        pet.setOwner(owner);
        pet.setType(type);
        Pet newPet = petRepository.save(pet);
        return modelMapper.map(newPet, PetDto.class);
    }

    @Override
    public PetDto findPetById(long id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Pet not found with id " + id));
        return modelMapper.map(pet, PetDto.class);
    }

    @Override
    public List<PetDto> findAllPets() {
        List<Pet> pets = petRepository.findAll();
        return pets.stream().map((pet) -> modelMapper.map(pet, PetDto.class)).collect(Collectors.toList());
    }

    @Override
    public PetDto updatePet(PetDto petDto, long id) {
        Pet pet = petRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Pet not found with id " + id));
        Owner owner = ownerRepository.findById(petDto.getOwnerId()).orElseThrow(()
                -> new ResourceNotFound("Owner not found with id " + petDto.getOwnerId()));
        PetType type = petTypeRepository.findById(petDto.getTypeId()).orElseThrow(()
                -> new ResourceNotFound("PetType not found with id " + petDto.getTypeId()));

        pet.setId(id);
        pet.setName(petDto.getName());
        pet.setOwner(owner);
        pet.setType(type);
        pet.setBirthDate(petDto.getBirthDate());
        pet.setVisits(petDto.getVisits());

        Pet savedPet = petRepository.save(pet);
        return modelMapper.map(savedPet, PetDto.class);
    }

    @Override
    public void deletePet(long id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Pet not found with id " + id));
        petRepository.delete(pet);
    }
}
