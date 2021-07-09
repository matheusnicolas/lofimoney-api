package com.lofi.lofimoney.api.service;

import com.lofi.lofimoney.api.model.Category;
import com.lofi.lofimoney.api.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category update(Long id, Category category) {
        Category savedCategory = searchCategoryById(id);
        BeanUtils.copyProperties(category, savedCategory, "id");
        return categoryRepository.save(savedCategory);
    }

    public Category searchCategoryById(Long id) {
        Category savedCategory = categoryRepository.findById(id).orElse(null);
        if (savedCategory == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return savedCategory;
    }
}
