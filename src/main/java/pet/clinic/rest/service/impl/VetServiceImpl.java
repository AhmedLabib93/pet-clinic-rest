package pet.clinic.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.clinic.rest.entity.Vet;
import pet.clinic.rest.exception.ResourceNotFound;
import pet.clinic.rest.payload.VetDto;
import pet.clinic.rest.repository.VetRepository;
import pet.clinic.rest.service.VetService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetServiceImpl implements VetService {


    @Autowired
    private VetRepository vetRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VetDto addVet(VetDto petDto) {
        Vet vet = modelMapper.map(petDto, Vet.class);
        Vet newVet = vetRepository.save(vet);
        return modelMapper.map(newVet, VetDto.class);
    }

    @Override
    public VetDto findVetById(long id) {
        Vet vet = vetRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Vet not found with id " + id));
        return modelMapper.map(vet, VetDto.class);
    }

    @Override
    public List<VetDto> findAllVets() {
        List<Vet> specialities = vetRepository.findAll();
        return specialities.stream().map((vet)
                -> modelMapper.map(vet, VetDto.class)).collect(Collectors.toList());
    }

    @Override
    public VetDto updateVet(VetDto vetDto, long id) {
        Vet vet = vetRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Vet not found with id " + id));


        vet.setId(id);
        vet.setFirstName(vetDto.getFirstName());
        vet.setLastName(vetDto.getLastName());
        vet.setSpecialities(vetDto.getSpecialities());

        Vet savedVet = vetRepository.save(vet);
        return modelMapper.map(savedVet, VetDto.class);
    }

    @Override
    public void deleteVet(long id) {
        Vet vet = vetRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Vet not found with id " + id));
        vetRepository.delete(vet);
    }
}
