package pet.clinic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.clinic.rest.payload.SpecialityDto;
import pet.clinic.rest.service.SpecialityService;

import java.util.List;

@RestController
@RequestMapping("/clinic/v1/speciality")
@CrossOrigin(origins = "http://localhost:4200")
public class SpecialityController {


    @Autowired
    private SpecialityService specialityService;

    @PostMapping
    public ResponseEntity<SpecialityDto> addSpeciality(@RequestBody SpecialityDto specialityDto) {
        return new ResponseEntity<SpecialityDto>(specialityService.addSpeciality(specialityDto), HttpStatus.CREATED);
    }

    @GetMapping("/{speciality-id}")
    public ResponseEntity<SpecialityDto> findSpecialityById(@PathVariable(name = "speciality-id") long id) {
        return ResponseEntity.ok(specialityService.findSpecialityById(id));
    }

    @GetMapping
    public ResponseEntity<List<SpecialityDto>> findAllSpecialities() {
        return ResponseEntity.ok(specialityService.findAllSpecialities());
    }

    @PutMapping("/{speciality-id}")
    public ResponseEntity<SpecialityDto> updateSpeciality(@RequestBody SpecialityDto specialityDto,
                                                          @PathVariable(name = "speciality-id") long id) {
        return new ResponseEntity<SpecialityDto>(specialityService.updateSpeciality(specialityDto, id),
                HttpStatus.ACCEPTED);
    }
}
