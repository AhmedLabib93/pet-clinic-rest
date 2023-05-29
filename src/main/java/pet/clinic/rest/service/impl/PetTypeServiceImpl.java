package pet.clinic.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.clinic.rest.entity.PetType;
import pet.clinic.rest.exception.ResourceNotFound;
import pet.clinic.rest.payload.PetTypeDto;
import pet.clinic.rest.repository.PetTypeRepository;
import pet.clinic.rest.service.PetTypeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetTypeServiceImpl implements PetTypeService {


    @Autowired
    private PetTypeRepository petRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PetTypeDto addPetType(PetTypeDto petDto) {
        PetType pet = modelMapper.map(petDto, PetType.class);
        PetType newPetType = petRepository.save(pet);
        return modelMapper.map(newPetType, PetTypeDto.class);
    }

    @Override
    public PetTypeDto findPetTypeById(long id) {
        PetType pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFound("PetType not found with id " + id));
        return modelMapper.map(pet, PetTypeDto.class);
    }

    @Override
    public List<PetTypeDto> findAllPetTypes() {
        List<PetType> petTypes = petRepository.findAll();
        return petTypes.stream().map((petType) -> modelMapper.map(petType, PetTypeDto.class)).collect(Collectors.toList());
    }

    @Override
    public PetTypeDto updatePetType(PetTypeDto petDto, long id) {
        PetType petType = petRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("PetType not found with id " + id));


        petType.setId(id);
        petType.setName(petDto.getName());

        PetType savedPetType = petRepository.save(petType);
        return modelMapper.map(savedPetType, PetTypeDto.class);
    }

    @Override
    public void deletePetType(long id) {
        PetType pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFound("PetType not found with id " + id));
        petRepository.delete(pet);
    }
}
