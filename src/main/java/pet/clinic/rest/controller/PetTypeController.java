package pet.clinic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.clinic.rest.payload.PetTypeDto;
import pet.clinic.rest.service.PetTypeService;

import java.util.List;

@RestController
@RequestMapping("/clinic/v1/types")
@CrossOrigin(origins = "http://localhost:4200")
public class PetTypeController {

    @Autowired
    private PetTypeService petTypeService;

    @PostMapping
    public ResponseEntity<PetTypeDto> addPetType(@RequestBody PetTypeDto typeDto) {
        return new ResponseEntity<PetTypeDto>(petTypeService.addPetType(typeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{type-id}")
    public ResponseEntity<PetTypeDto> findPetTypeById(@PathVariable(name = "type-id") long id) {
        return ResponseEntity.ok(petTypeService.findPetTypeById(id));
    }

    @GetMapping
    public ResponseEntity<List<PetTypeDto>> findAllPetTypes() {
        return ResponseEntity.ok(petTypeService.findAllPetTypes());
    }

    @PutMapping("/{type-id}")
    public ResponseEntity<PetTypeDto> updatePetType(@RequestBody PetTypeDto typeDto,
                                            @PathVariable(name = "type-id") long id) {
        return new ResponseEntity<PetTypeDto>(petTypeService.updatePetType(typeDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{type-id}")
    public ResponseEntity<String> deletePetType(@PathVariable(name = "type-id") long id) {
        petTypeService.deletePetType(id);
        return new ResponseEntity<>("PetType deleted successfully!", HttpStatus.ACCEPTED);
    }
}
