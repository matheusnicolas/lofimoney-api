package com.lofi.lofimoney.api.service;

import com.lofi.lofimoney.api.model.Person;
import com.lofi.lofimoney.api.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person update(Long id, Person person) {
        Person savedPerson = searchPersonById(id);
        BeanUtils.copyProperties(person, savedPerson, "id");
        return personRepository.save(savedPerson);
    }

    public void updateActiveProperty(Long id, Boolean active) {
        Person savedPerson = searchPersonById(id);
        savedPerson.setActive(active);
        personRepository.save(savedPerson);
    }

    private Person searchPersonById(Long id) {
        Person savedPerson = personRepository.findById(id).orElse(null);
        if (savedPerson == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return savedPerson;
    }
}
