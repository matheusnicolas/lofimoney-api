package com.lofi.lofimoney.api.service;

import com.lofi.lofimoney.api.model.Person;
import com.lofi.lofimoney.api.model.Release;
import com.lofi.lofimoney.api.repository.PersonRepository;
import com.lofi.lofimoney.api.repository.ReleaseRepository;
import com.lofi.lofimoney.api.service.exception.PersonNonExistentOrIsInactive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ReleaseRepository repository;

    public Release save(Release release) {
        Person person = personRepository.findById(release.getPerson().getId()).orElse(null);
        if (person == null || person.isInactive()) {
            throw new PersonNonExistentOrIsInactive();
        }

        return repository.save(release);
    }
}
