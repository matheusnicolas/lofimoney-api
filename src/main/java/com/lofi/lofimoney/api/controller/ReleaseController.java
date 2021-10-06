package com.lofi.lofimoney.api.controller;

import com.lofi.lofimoney.api.event.CreatedResourceEvent;
import com.lofi.lofimoney.api.model.Release;
import com.lofi.lofimoney.api.repository.ReleaseRepository;
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
public class ReleaseController {

    @Autowired
    private ReleaseRepository repository;

    private ApplicationEventPublisher publisher;

    @GetMapping("/releases")
    public List<Release> list () {
        return repository.findAll();
    }

    @GetMapping("/releases/{id}")
    public Release getReleaseById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/releases")
    public ResponseEntity<Release> create(@Valid @RequestBody Release release, HttpServletResponse response) {
        Release savedRelease = repository.save(release);
        publisher.publishEvent(new CreatedResourceEvent(this, response, savedRelease.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRelease);
    }

}
