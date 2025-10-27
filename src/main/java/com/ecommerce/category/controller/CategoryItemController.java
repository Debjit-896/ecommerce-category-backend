package com.ecommerce.category.controller;

import com.ecommerce.category.model.CategoryItem;
import com.ecommerce.category.service.CategoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category-items")
public class CategoryItemController {

    @Autowired
    private final CategoryItemService categoryItemService;

    // GET all category
    @GetMapping
    public ResponseEntity<List<CategoryItem>> getAllCategoryItems() {
        return ResponseEntity.ok(categoryItemService.getAllCategoryItem());
    }

    // GET category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryItem> getCategoryItemById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryItemService.getCategoryItemById(id));
    }

    // CREATE new category
    @PostMapping
    public ResponseEntity<CategoryItem> createCategoryItem(@RequestBody CategoryItem categoryItem) {
        CategoryItem saved = categoryItemService.createCategoryItem(categoryItem);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // UPDATE category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryItem> updateCategoryItem(@PathVariable Long id, @RequestBody CategoryItem categoryItem) {
        CategoryItem updated = categoryItemService.updateCategoryItem(id, categoryItem);
        return ResponseEntity.ok(updated);
    }

    // DELETE category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryItem(@PathVariable Long id) {
        categoryItemService.deleteCategoryItem(id);
        return ResponseEntity.noContent().build();
    }
}
