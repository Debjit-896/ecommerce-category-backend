package com.ecommerce.category.service;

import com.ecommerce.category.dto.ProductRequestDto;
import com.ecommerce.category.dto.ProductResponseDto;
import com.ecommerce.category.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(Long id);

    ProductResponseDto createProduct(ProductRequestDto product);

    ProductResponseDto updateProduct(Long id, ProductRequestDto product);
    void deleteProduct(Long id);
}
