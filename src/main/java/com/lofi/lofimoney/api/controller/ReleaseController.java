package com.lofi.lofimoney.api.controller;

import com.lofi.lofimoney.api.model.Release;
import com.lofi.lofimoney.api.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReleaseController {

    @Autowired
    private ReleaseRepository repository;

    @GetMapping("/releases")
    public List<Release> list () {
        return repository.findAll();
    }

}
