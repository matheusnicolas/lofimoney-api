package com.lofi.lofimoney.api.resource;

import com.lofi.lofimoney.api.model.Person;
import com.lofi.lofimoney.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> list() { return personRepository.findAll(); }

    @PostMapping("/persons")
    public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response) {
        Person savedPerson = personRepository.save(person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("{/id}").buildAndExpand(savedPerson.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(savedPerson);
    }

    @GetMapping("/persons/{id}")
    public Person findById(@PathVariable Long id) { return personRepository.findById(id).orElse(null); }
}
