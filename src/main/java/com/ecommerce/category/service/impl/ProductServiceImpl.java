package com.ecommerce.category.service.impl;

import com.ecommerce.category.dto.ProductRequestDto;
import com.ecommerce.category.dto.ProductResponseDto;
import com.ecommerce.category.exception.ResourceNotFoundException;
import com.ecommerce.category.mapper.ProductMapper;
import com.ecommerce.category.model.CategoryItem;
import com.ecommerce.category.model.Product;
import com.ecommerce.category.repository.ProductRepository;
import com.ecommerce.category.service.CategoryItemService;
import com.ecommerce.category.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;
    private final CategoryItemService categoryItemService;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by id " + id));
        return ProductMapper.toDTO(product);
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto) {
        CategoryItem categoryItem = categoryItemService.getCategoryItemById(dto.getCategoryItemId());
        Product product = ProductMapper.toEntity(dto, categoryItem);
        Product saved = productRepository.save(product);
        return ProductMapper.toDTO(saved);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto dto) {
        Product product = productRepository.
                findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found. Update failed."));

        product.setTitle(dto.getTitle());
        product.setBrand(dto.getBrand());
        product.setDescription(dto.getDescription());
        product.setShortDescription(dto.getShortDescription());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());
        product.setMainImageUrl(dto.getMainImageUrl());
        product.setGalleryImages(dto.getGalleryImages());
        product.setIsAvailable(dto.getIsAvailable());

        Product updated = productRepository.save(product);
        return ProductMapper.toDTO(updated);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
