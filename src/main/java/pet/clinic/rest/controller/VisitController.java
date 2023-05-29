package pet.clinic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.clinic.rest.payload.VisitDto;
import pet.clinic.rest.service.VisitService;

import java.util.List;

@RestController
@RequestMapping("/clinic/v1/visits")
@CrossOrigin(origins = "http://localhost:4200")
public class VisitController {


    @Autowired
    private VisitService visitService;

    @PostMapping
    public ResponseEntity<VisitDto> addVisit(@RequestBody VisitDto visitDto) {
        return new ResponseEntity<VisitDto>(visitService.addVisit(visitDto), HttpStatus.CREATED);
    }

    @GetMapping("/{visit-id}")
    public ResponseEntity<VisitDto> findVisitById(@PathVariable(name = "visit-id") long id) {
        return ResponseEntity.ok(visitService.findVisitById(id));
    }

    @GetMapping("/pet/{pet-id}")
    public ResponseEntity<List<VisitDto>> findByPetId(@PathVariable(name = "pet-id") long id) {
        return ResponseEntity.ok(visitService.findByPetId(id));
    }

    @GetMapping
    public ResponseEntity<List<VisitDto>> findAllSpecialities() {
        return ResponseEntity.ok(visitService.findAllVisits());
    }

    @PutMapping("/{visit-id}")
    public ResponseEntity<VisitDto> updateVisit(@RequestBody VisitDto visitDto,
                                                @PathVariable(name = "visit-id") long id) {
        return new ResponseEntity<VisitDto>(visitService.updateVisit(visitDto, id),
                HttpStatus.ACCEPTED);
    }
}
