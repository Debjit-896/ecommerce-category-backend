package com.ecommerce.category.service;

import com.ecommerce.category.model.CategoryType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryTypeService {

    List<CategoryType> getAllCategoryTypes();
    CategoryType getCategoryTypeById(Long id);
    CategoryType createCategoryType(CategoryType categoryType);
    CategoryType updateCategoryType(Long id, CategoryType categoryType);
    void deleteCategoryType(Long id);
}
