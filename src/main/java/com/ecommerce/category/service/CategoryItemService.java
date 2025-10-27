package com.ecommerce.category.service;

import com.ecommerce.category.model.CategoryItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryItemService {

    List<CategoryItem> getAllCategoryItem();
    CategoryItem getCategoryItemById(Long id);
    CategoryItem createCategoryItem(CategoryItem categoryItem);
    CategoryItem updateCategoryItem(Long id, CategoryItem categoryItem);
    void deleteCategoryItem(Long id);
}
