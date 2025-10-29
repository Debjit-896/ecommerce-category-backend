package com.ecommerce.category.service.impl;

import com.ecommerce.category.exception.ResourceNotFoundException;
import com.ecommerce.category.model.Category;
import com.ecommerce.category.repository.CategoryRepository;
import com.ecommerce.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " +id));
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category with ID " + id + " not found. Update failed."));

        category.setName(updatedCategory.getName());
        category.setImageUrl(updatedCategory.getImageUrl());
        category.setActive(updatedCategory.getActive());

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            log.info("Successfully deleted Category with ID: {}", id);
        } else {
            throw new ResourceNotFoundException("Category with ID " + id + " not found. Deletion failed.");
        }
    }
}
