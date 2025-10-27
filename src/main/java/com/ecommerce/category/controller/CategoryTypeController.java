package com.ecommerce.category.controller;

import com.ecommerce.category.model.CategoryType;
import com.ecommerce.category.service.CategoryTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category-types")
public class CategoryTypeController {

    @Autowired
    private final CategoryTypeService categoryTypeService;

    // GET all category type
    @GetMapping
    public ResponseEntity<List<CategoryType>> getAllCategoryType() {
        return ResponseEntity.ok(categoryTypeService.getAllCategoryTypes());
    }

    // GET category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryType> getCategoryTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryTypeService.getCategoryTypeById(id));
    }

    // CREATE new category
    @PostMapping
    public ResponseEntity<CategoryType> createCategory(@RequestBody CategoryType categoryType){
        CategoryType savedCategoryType = categoryTypeService.createCategoryType(categoryType);
        return new ResponseEntity<>(savedCategoryType, HttpStatus.CREATED);
    }

    // UPDATE category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryType> updateCategoryType(@PathVariable Long id, @RequestBody CategoryType categoryType) {
        CategoryType updated = categoryTypeService.updateCategoryType(id, categoryType);
        return ResponseEntity.ok(updated);
    }

    // DELETE category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryType(@PathVariable Long id){
        categoryTypeService.deleteCategoryType(id);
        return ResponseEntity.noContent().build();
    }
}
