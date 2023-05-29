package pet.clinic.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.clinic.rest.entity.Speciality;
import pet.clinic.rest.exception.ResourceNotFound;
import pet.clinic.rest.payload.SpecialityDto;
import pet.clinic.rest.repository.SpecialityRepository;
import pet.clinic.rest.service.SpecialityService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialityServiceImpl implements SpecialityService {


    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SpecialityDto addSpeciality(SpecialityDto petDto) {
        Speciality speciality = modelMapper.map(petDto, Speciality.class);
        Speciality newSpeciality = specialityRepository.save(speciality);
        return modelMapper.map(newSpeciality, SpecialityDto.class);
    }

    @Override
    public SpecialityDto findSpecialityById(long id) {
        Speciality speciality = specialityRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Speciality not found with id " + id));
        return modelMapper.map(speciality, SpecialityDto.class);
    }

    @Override
    public List<SpecialityDto> findAllSpecialities() {
        List<Speciality> specialities = specialityRepository.findAll();
        return specialities.stream().map((speciality)
                -> modelMapper.map(speciality, SpecialityDto.class)).collect(Collectors.toList());
    }

    @Override
    public SpecialityDto updateSpeciality(SpecialityDto specialityDto, long id) {
        Speciality speciality = specialityRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Speciality not found with id " + id));


        speciality.setId(id);
        speciality.setName(specialityDto.getName());

        Speciality savedSpeciality = specialityRepository.save(speciality);
        return modelMapper.map(savedSpeciality, SpecialityDto.class);
    }

    @Override
    public void deleteSpeciality(long id) {
        Speciality speciality = specialityRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound("Speciality not found with id " + id));
        specialityRepository.delete(speciality);
    }
}
