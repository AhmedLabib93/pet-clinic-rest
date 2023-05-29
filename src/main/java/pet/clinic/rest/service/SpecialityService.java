package pet.clinic.rest.service;

import pet.clinic.rest.payload.SpecialityDto;

import java.util.List;

public interface SpecialityService {

    SpecialityDto addSpeciality(SpecialityDto specialityDto);

    SpecialityDto findSpecialityById(long id);

    List<SpecialityDto> findAllSpecialities();

    SpecialityDto updateSpeciality(SpecialityDto specialityDto, long id);

    void deleteSpeciality(long id);
}
