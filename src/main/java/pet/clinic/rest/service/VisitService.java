package pet.clinic.rest.service;

import pet.clinic.rest.payload.VisitDto;

import java.util.List;

public interface VisitService {


    VisitDto addVisit(VisitDto visitDto);

    List<VisitDto> findByPetId(long id);

    VisitDto findVisitById(long id);

    List<VisitDto> findAllVisits();

    VisitDto updateVisit(VisitDto visitDto, long id);

    void deleteVisit(long id);
}
