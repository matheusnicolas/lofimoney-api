package com.lofi.lofimoney.api.resource;

import com.lofi.lofimoney.api.model.Category;
import com.lofi.lofimoney.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> create(@RequestBody Category category, HttpServletResponse response) {
       Category savedCategory = categoryRepository.save(category);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
               .path("{/code}").buildAndExpand(savedCategory.getCode()).toUri();
       response.setHeader("Location", uri.toASCIIString());

       return ResponseEntity.created(uri).body(savedCategory);
    }

    @GetMapping("/categories/{code}")
    public Category findByCode(@PathVariable Long code) {
        return categoryRepository.findById(code).orElse(null);
    }
}
