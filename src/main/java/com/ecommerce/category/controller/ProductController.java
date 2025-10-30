package com.ecommerce.category.controller;

import com.ecommerce.category.dto.ApiResponse;
import com.ecommerce.category.dto.ProductRequestDto;
import com.ecommerce.category.dto.ProductResponseDto;
import com.ecommerce.category.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    // GET all products
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllProduct() {
        List<ProductResponseDto> response = productService.getAllProducts();
        return ResponseEntity.ok(ApiResponse
                .success("Products fetched successfully",
                        response));
    }

    // GET product by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getProductById(@PathVariable Long id) {
        ProductResponseDto response = productService.getProductById(id);
        return ResponseEntity.ok(ApiResponse
                .success("Product fetched successfully",
                        response));
    }

    // CREATE new product
    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponseDto>> createProduct(@RequestBody ProductRequestDto dto) {
        ProductResponseDto created = productService.createProduct(dto);
        return ResponseEntity.ok(ApiResponse.success("Product created successfully", created));
    }

    // UPDATE product
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto dto) {
        ProductResponseDto updatedProduct = productService.updateProduct(id, dto);
        return ResponseEntity.ok(ApiResponse.success(
                "Product updated successfully",
                updatedProduct));
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(ApiResponse
                .success("Product deleted successfully",
                        null));
    }
}
