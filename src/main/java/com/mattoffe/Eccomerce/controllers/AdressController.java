package com.mattoffe.Eccomerce.controllers;

import com.mattoffe.Eccomerce.dtos.AdressDTO;
import com.mattoffe.Eccomerce.model.Adress;
import com.mattoffe.Eccomerce.model.Person;
import com.mattoffe.Eccomerce.repositories.AdressRepository;
import com.mattoffe.Eccomerce.repositories.PersonRepository;
import com.mattoffe.Eccomerce.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/adress")
public class AdressController {
    @Autowired
    private AdressRepository adressRepository;
    @Autowired
    private AdressService adressService;
    @Autowired
    private PersonRepository personRepository;
    @GetMapping("/all")
    public List<AdressDTO> getAllAdress(Authentication authentication) {
        Person person =  personRepository.findByEmail(authentication.getName());
        return adressService.findByPerson(person).stream().map(AdressDTO::new).collect(toList());
    }
    @PostMapping("/add")
    public ResponseEntity<Object> saveAdress(@RequestBody AdressDTO adress, Authentication authentication) {
        Person person =  personRepository.findByEmail(authentication.getName());
        if(person == null){
            return new ResponseEntity<>("Client not found", HttpStatus.LOCKED);
        }
        if (adress.getStreet().isBlank()) {
            return new ResponseEntity<>("Street is required", HttpStatus.BAD_REQUEST);
        }
        if (adress.getCity().isBlank()) {
            return new ResponseEntity<>("City is required", HttpStatus.BAD_REQUEST);
        }
        if (adress.getApartament().isBlank()) {
            return new ResponseEntity<>("Apartament is required", HttpStatus.BAD_REQUEST);
        }
        if (adress.getZip().isBlank()) {
            return new ResponseEntity<>("Zip is required", HttpStatus.BAD_REQUEST);
        }
        if (adress.getNumber() <= 0) {
            return new ResponseEntity<>("Number is required", HttpStatus.BAD_REQUEST);
        }
        if (adress.getFloor() <= 0) {
            return new ResponseEntity<>("Floor is required", HttpStatus.BAD_REQUEST);
        }
        Adress adressEntity = new Adress(adress.getStreet(),adress.getCity(),adress.getApartament(),adress.getZip(),adress.getNumber(),adress.getFloor(),adress.isStatus());
        adressService.saveAdress(adressEntity);
        adressEntity.setPerson(person);
        person.addAdress(adressEntity);
        personRepository.save(person);
        return new ResponseEntity<>("Adress created", HttpStatus.CREATED);
    }
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAdress(@PathVariable Long id, Authentication authentication) {
        Person person =  personRepository.findByEmail(authentication.getName());
        if(person == null){
            return new ResponseEntity<>("Client not found", HttpStatus.LOCKED);
        }
        if (id <= 0) {
            return new ResponseEntity<>("Id is required", HttpStatus.BAD_REQUEST);
        }
        boolean exists = adressRepository.existsById(id);
        if(!exists){
            return new ResponseEntity<>("Adress not found", HttpStatus.NOT_FOUND);
        }
        Adress adress = adressRepository.findById(id).orElse(null);

        if(adress.getPerson().getId() != person.getId()){
            return new ResponseEntity<>("Adress not assigned to this person", HttpStatus.NOT_FOUND);
        }
        adress.setStatus(false);
        adressRepository.save(adress);
        return new ResponseEntity<>("Adress deleted", HttpStatus.OK);
    }
}
