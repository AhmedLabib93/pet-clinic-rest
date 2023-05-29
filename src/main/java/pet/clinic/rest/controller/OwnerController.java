package pet.clinic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.clinic.rest.payload.OwnerDto;
import pet.clinic.rest.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/clinic/v1/owners")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerDto> addOwner(@RequestBody OwnerDto ownerDto) {
        return new ResponseEntity<OwnerDto>(ownerService.addOwner(ownerDto), HttpStatus.CREATED);
    }

    @GetMapping("/{owner-id}")
    public ResponseEntity<OwnerDto> findOwnerById(@PathVariable(name = "owner-id") long id) {
        return ResponseEntity.ok(ownerService.findOwnerById(id));
    }

    @GetMapping("/last-name")
    public ResponseEntity<List<OwnerDto>> findOwnersByLastName(
            @RequestParam(value = "last-name", required = true) String lastName) {
        return ResponseEntity.ok(ownerService.findOwnersByLastName(lastName));
    }

    @GetMapping
    public ResponseEntity<List<OwnerDto>> findAllOwners() {
        return ResponseEntity.ok(ownerService.findAllOwners());
    }

    @PutMapping("/{owner-id}")
    public ResponseEntity<OwnerDto> updateOwner(@RequestBody OwnerDto ownerDto,
                                                @PathVariable(name = "owner-id") long id) {
        return new ResponseEntity<OwnerDto>(ownerService.updateOwner(ownerDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{owner-id}")
    public ResponseEntity<String> deleteOwner(@PathVariable(name = "owner-id") long id) {
        ownerService.deleteOwner(id);
        return new ResponseEntity<>("Owner deleted successfully!", HttpStatus.ACCEPTED);
    }
}
