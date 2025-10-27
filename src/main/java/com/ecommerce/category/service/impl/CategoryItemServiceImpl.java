package com.ecommerce.category.service.impl;

import com.ecommerce.category.exception.ResourceNotFoundException;
import com.ecommerce.category.model.CategoryItem;
import com.ecommerce.category.repository.CategoryItemRepository;
import com.ecommerce.category.service.CategoryItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryItemServiceImpl implements CategoryItemService {

    @Autowired
    private final CategoryItemRepository categoryItemRepository;

    @Override
    public List<CategoryItem> getAllCategoryItem() {
        return categoryItemRepository.findAll();
    }

    @Override
    public CategoryItem getCategoryItemById(Long id) {
        return categoryItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found by id " +id));
    }

    @Override
    public CategoryItem createCategoryItem(CategoryItem categoryItem) {
        return categoryItemRepository.save(categoryItem);
    }

    @Override
    public CategoryItem updateCategoryItem(Long id, CategoryItem updatedCategoryItem) {
        CategoryItem categoryItem = categoryItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found. Update failed."));

        categoryItem.setName(updatedCategoryItem.getName());
        categoryItem.setDescription(updatedCategoryItem.getDescription());
        categoryItem.setImageUrl(updatedCategoryItem.getImageUrl());
        categoryItem.setActive(updatedCategoryItem.getActive());

        return categoryItemRepository.save(categoryItem);
    }

    @Override
    public void deleteCategoryItem(Long id) {
        if (categoryItemRepository.existsById(id)){
            categoryItemRepository.deleteById(id);
            log.info("Successfully deleted Category item with ID: {}", id);
        } else {
            throw new ResourceNotFoundException("Category item with ID " + id + " not found. Deletion failed.");
        }
    }
}
