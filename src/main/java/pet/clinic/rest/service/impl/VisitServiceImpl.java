package pet.clinic.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.clinic.rest.entity.Pet;
import pet.clinic.rest.entity.Visit;
import pet.clinic.rest.exception.ResourceNotFound;
import pet.clinic.rest.payload.VisitDto;
import pet.clinic.rest.repository.PetRepository;
import pet.clinic.rest.repository.VisitRepository;
import pet.clinic.rest.service.VisitService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VisitDto addVisit(VisitDto petDto) {
        Visit visit = modelMapper.map(petDto, Visit.class);
        Visit newVisit = visitRepository.save(visit);
        return modelMapper.map(newVisit, VisitDto.class);
    }

    @Override
    public List<VisitDto> findByPetId(long id) {
        Pet pet = petRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Pet not found with id " + id));
        return pet.getVisits().stream().map((visit)
                -> modelMapper.map(visit, VisitDto.class)).collect(Collectors.toList());
    }

    @Override
    public VisitDto findVisitById(long id) {
        Visit visit = visitRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Visit not found with id " + id));
        return modelMapper.map(visit, VisitDto.class);
    }

    @Override
    public List<VisitDto> findAllVisits() {
        List<Visit> specialities = visitRepository.findAll();
        return specialities.stream().map((visit)
                -> modelMapper.map(visit, VisitDto.class)).collect(Collectors.toList());
    }

    @Override
    public VisitDto updateVisit(VisitDto visitDto, long id) {
        Visit visit = visitRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Visit not found with id " + id));

        Pet pet = petRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Pet not found with id " + id));


        visit.setId(id);
        visit.setDescription(visitDto.getDescription());
        visit.setDate(visitDto.getDate());
        visit.setPet(pet);

        Visit savedVisit = visitRepository.save(visit);
        return modelMapper.map(savedVisit, VisitDto.class);
    }

    @Override
    public void deleteVisit(long id) {
        Visit visit = visitRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Visit not found with id " + id));
        visitRepository.delete(visit);
    }
}
