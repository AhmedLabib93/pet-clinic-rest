package pet.clinic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.clinic.rest.payload.VetDto;
import pet.clinic.rest.service.VetService;

import java.util.List;

@RestController
@RequestMapping("/clinic/v1/vets")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {

    @Autowired
    private VetService vetService;

    @PostMapping
    public ResponseEntity<VetDto> addVet(@RequestBody VetDto vetDto) {
        return new ResponseEntity<VetDto>(vetService.addVet(vetDto), HttpStatus.CREATED);
    }

    @GetMapping("/{vet-id}")
    public ResponseEntity<VetDto> findVetById(@PathVariable(name = "vet-id") long id) {
        return ResponseEntity.ok(vetService.findVetById(id));
    }

    @GetMapping
    public ResponseEntity<List<VetDto>> findAllSpecialities() {
        return ResponseEntity.ok(vetService.findAllVets());
    }

    @PutMapping("/{vet-id}")
    public ResponseEntity<VetDto> updateVet(@RequestBody VetDto vetDto,
                                            @PathVariable(name = "vet-id") long id) {
        return new ResponseEntity<VetDto>(vetService.updateVet(vetDto, id),
                HttpStatus.ACCEPTED);
    }
}
