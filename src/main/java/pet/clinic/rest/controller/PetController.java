package pet.clinic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.clinic.rest.payload.PetDto;
import pet.clinic.rest.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/clinic/v1/pets")
@CrossOrigin(origins = "http://localhost:4200")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<PetDto> addPet(@RequestBody PetDto petDto) {
        return new ResponseEntity<PetDto>(petService.addPet(petDto), HttpStatus.CREATED);
    }

    @GetMapping("/{pet-id}")
    public ResponseEntity<PetDto> findPetById(@PathVariable(name = "pet-id") long id) {
        return ResponseEntity.ok(petService.findPetById(id));
    }

    @GetMapping
    public ResponseEntity<List<PetDto>> findAllPets() {
        return ResponseEntity.ok(petService.findAllPets());
    }

    @PutMapping("/{pet-id}")
    public ResponseEntity<PetDto> updatePet(@RequestBody PetDto petDto,
                                                @PathVariable(name = "pet-id") long id) {
        return new ResponseEntity<PetDto>(petService.updatePet(petDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{pet-id}")
    public ResponseEntity<String> deletePet(@PathVariable(name = "pet-id") long id) {
        petService.deletePet(id);
        return new ResponseEntity<>("Pet deleted successfully!", HttpStatus.ACCEPTED);
    }
}
