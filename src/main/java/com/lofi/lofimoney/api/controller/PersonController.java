package com.lofi.lofimoney.api.controller;

import com.lofi.lofimoney.api.event.CreatedResourceEvent;
import com.lofi.lofimoney.api.model.Person;
import com.lofi.lofimoney.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/persons")
    public List<Person> list() { return personRepository.findAll(); }

    @PostMapping("/persons")
    public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response) {
        Person savedPerson = personRepository.save(person);
        publisher.publishEvent(new CreatedResourceEvent(this, response, savedPerson.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @GetMapping("/persons/{id}")
    public Person findById(@PathVariable Long id) { return personRepository.findById(id).orElse(null); }

    @DeleteMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
