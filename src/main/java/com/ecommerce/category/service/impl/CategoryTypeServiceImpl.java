package com.ecommerce.category.service.impl;

import com.ecommerce.category.exception.ResourceNotFoundException;
import com.ecommerce.category.model.CategoryType;
import com.ecommerce.category.repository.CategoryTypeRepository;
import com.ecommerce.category.service.CategoryTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryTypeServiceImpl implements CategoryTypeService {

    @Autowired
    private final CategoryTypeRepository categoryTypeRepository;

    @Override
    public List<CategoryType> getAllCategoryTypes() {
        return categoryTypeRepository.findAll();
    }

    @Override
    public CategoryType getCategoryTypeById(Long id) {
        return categoryTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CategoryType not found with id: " +id));
    }

    @Override
    public CategoryType createCategoryType(CategoryType categoryType) {
        return categoryTypeRepository.save(categoryType);
    }

    @Override
    public CategoryType updateCategoryType(Long id, CategoryType updatedCategoryType) {
        CategoryType categoryType = categoryTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category Type with ID " + id + " not found. Update failed."));

        categoryType.setName(updatedCategoryType.getName());
        categoryType.setImageUrl(updatedCategoryType.getImageUrl());
        categoryType.setReturnable(updatedCategoryType.getReturnable());
        categoryType.setWarrantyApplicable(updatedCategoryType.getWarrantyApplicable());

        return categoryTypeRepository.save(categoryType);
    }

    @Override
    public void deleteCategoryType(Long id) {
        if (categoryTypeRepository.existsById(id)){
            categoryTypeRepository.deleteById(id);
            log.info("Successfully deleted Category Type with ID: {}", id);
        } else {
            throw new ResourceNotFoundException("Category Type with ID " + id + " not found. Deletion failed.");
        }

    }
}
