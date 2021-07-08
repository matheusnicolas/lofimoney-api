package com.lofi.lofimoney.api.controller;

import com.lofi.lofimoney.api.event.CreatedResourceEvent;
import com.lofi.lofimoney.api.model.Category;
import com.lofi.lofimoney.api.repository.CategoryRepository;
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
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/categories")
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> create(@Valid @RequestBody Category category, HttpServletResponse response) {
       Category savedCategory = categoryRepository.save(category);
       publisher.publishEvent(new CreatedResourceEvent(this, response, savedCategory.getId()));
       return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/categories/{code}")
    public Category findByCode(@PathVariable Long code) {
        return categoryRepository.findById(code).orElse(null);
    }
}
