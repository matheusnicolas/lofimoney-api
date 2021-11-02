package com.lofi.lofimoney.api.controller;

import com.lofi.lofimoney.api.event.CreatedResourceEvent;
import com.lofi.lofimoney.api.exceptionHandler.LofimoneyExceptionHandler;
import com.lofi.lofimoney.api.model.Release;
import com.lofi.lofimoney.api.repository.ReleaseRepository;
import com.lofi.lofimoney.api.service.ReleaseService;
import com.lofi.lofimoney.api.service.exception.PersonNonExistentOrIsInactive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReleaseController {

    @Autowired
    private ReleaseRepository repository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private ReleaseService service;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/releases")
    public List<Release> list () {
        return repository.findAll();
    }

    @PostMapping("/releases")
    public ResponseEntity<Release> create(@Valid @RequestBody Release release, HttpServletResponse response) {
        Release savedRelease = service.save(release);
        publisher.publishEvent(new CreatedResourceEvent(this, response, savedRelease.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRelease);
    }

    @GetMapping("/releases/{id}")
    public Release getReleaseById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @ExceptionHandler({ PersonNonExistentOrIsInactive.class })
    public ResponseEntity<Object> handlePersonNonExistentOrIsInactiveException(PersonNonExistentOrIsInactive exception) {
        String userMessage = messageSource.getMessage("person.nonexistent-or-inactive", null, LocaleContextHolder.getLocale());
        String developerMessage = exception.toString();
        List<LofimoneyExceptionHandler.Error> errors = Arrays.asList(new LofimoneyExceptionHandler.Error(userMessage, developerMessage));
        return ResponseEntity.badRequest().body(errors);
    }

}
