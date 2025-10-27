package com.ecommerce.category.service.impl;

import com.ecommerce.category.exception.ResourceNotFoundException;
import com.ecommerce.category.model.Product;
import com.ecommerce.category.repository.ProductRepository;
import com.ecommerce.category.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found by id " +id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found. Update failed."));

        product.setName(updatedProduct.getName());
        product.setBrand(updatedProduct.getBrand());
        product.setDescription(updatedProduct.getDescription());
        product.setShortDescription(updatedProduct.getShortDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setStockQuantity(updatedProduct.getStockQuantity());
        product.setMainImageUrl(updatedProduct.getMainImageUrl());
        product.setGalleryImages(updatedProduct.getGalleryImages());
        product.setIsAvailable(updatedProduct.getIsAvailable());

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            log.info("Successfully deleted Product with ID: {}", id);
        } else {
            throw new ResourceNotFoundException("Product with ID " + id + " not found. Deletion failed.");
        }
    }
}
