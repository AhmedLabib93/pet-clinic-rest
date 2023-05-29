package pet.clinic.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.clinic.rest.exception.ResourceNotFound;
import pet.clinic.rest.entity.Owner;
import pet.clinic.rest.payload.OwnerDto;
import pet.clinic.rest.repository.OwnerRepository;
import pet.clinic.rest.service.OwnerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OwnerDto addOwner(OwnerDto ownerDto) {
        Owner owner = modelMapper.map(ownerDto, Owner.class);
        Owner newOwner = ownerRepository.save(owner);
        return modelMapper.map(newOwner, OwnerDto.class);
    }

    @Override
    public OwnerDto findOwnerById(long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Owner not found with id " + id));
        return modelMapper.map(owner, OwnerDto.class);
    }

    @Override
    public List<OwnerDto> findOwnersByLastName(String lastName) {
        List<Owner> owners = ownerRepository.findByLastName(lastName);
        return owners.stream().map((owner) -> modelMapper.map(owner, OwnerDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<OwnerDto> findAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream().map((owner) -> modelMapper.map(owner, OwnerDto.class)).collect(Collectors.toList());
    }

    @Override
    public OwnerDto updateOwner(OwnerDto ownerDto, long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Owner not found with id " + id));

        owner.setId(id);
        owner.setAddress(ownerDto.getAddress());
        owner.setCity(ownerDto.getCity());
        owner.setPets(ownerDto.getPets());
        owner.setPhone(ownerDto.getPhone());
        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());

        Owner savedOwner = ownerRepository.save(owner);
        return modelMapper.map(savedOwner, OwnerDto.class);
    }

    @Override
    public void deleteOwner(long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Owner not found with id " + id));
        ownerRepository.delete(owner);
    }
}
