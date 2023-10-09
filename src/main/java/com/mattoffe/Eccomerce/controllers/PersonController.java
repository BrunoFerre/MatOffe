package com.mattoffe.Eccomerce.controllers;

import com.mattoffe.Eccomerce.dtos.PersonDTO;
import com.mattoffe.Eccomerce.model.Person;
import com.mattoffe.Eccomerce.model.enums.PersonType;
import com.mattoffe.Eccomerce.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/clients")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all")
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream().map(PersonDTO::new).collect(toList());
    }

    @GetMapping("/authenticated")
    public PersonDTO findClient(String email) {
        return new PersonDTO(personRepository.findByEmail(email));
    }
    @PostMapping("/add")
    public ResponseEntity<Object> register(@RequestBody PersonDTO person) {
        if (person.getFirstName().isBlank()) {
            return new ResponseEntity<>("First name is required", HttpStatus.BAD_REQUEST);
        }
        if (person.getLastName().isBlank()) {
            return new ResponseEntity<>("Last name is required", HttpStatus.BAD_REQUEST);
        }
        if (person.getEmail().isBlank()) {
            return new ResponseEntity<>("Email is required", HttpStatus.BAD_REQUEST);
        }
        if (person.getPassword().isBlank()) {
            return new ResponseEntity<>("Password is required", HttpStatus.BAD_REQUEST);
        }
        Person personEntity = new Person(person.getFirstName(), person.getLastName(), person.getEmail(), person.getPassword(), PersonType.CLIENT);
        personRepository.save(personEntity);
        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }
    @PatchMapping("/update")
    public ResponseEntity<Object> assignAdmin(@RequestParam String email) {
        if (email.isBlank()) {
            return new ResponseEntity<>("Email is required", HttpStatus.BAD_REQUEST);
        }
        Person personEntity = personRepository.findByEmail(email);
        if (personEntity.getType().equals(PersonType.ADMIN)) {
            return new ResponseEntity<>("Admin already assigned", HttpStatus.BAD_REQUEST);
        }
        personEntity.setType(PersonType.ADMIN);
        personRepository.save(personEntity);
        return new ResponseEntity<>("Admin assigned", HttpStatus.OK);
    }
}
