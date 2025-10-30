package com.ecommerce.category.mapper;

import com.ecommerce.category.dto.ProductRequestDto;
import com.ecommerce.category.dto.ProductResponseDto;
import com.ecommerce.category.model.CategoryItem;
import com.ecommerce.category.model.Product;

public class ProductMapper {
    public static Product toEntity(ProductRequestDto dto, CategoryItem categoryItem) {
        return Product.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .shortDescription(dto.getShortDescription())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .discountedPrice(dto.getDiscountedPrice())
                .discountPercent(dto.getDiscountPercent())
                .stockQuantity(dto.getStockQuantity())
                .color(dto.getColor())
                .sizes(dto.getSizes())
                .mainImageUrl(dto.getMainImageUrl())
                .galleryImages(dto.getGalleryImages())
                .isAvailable(dto.getIsAvailable())
                .categoryItem(categoryItem)
                .build();
    }

    public static ProductResponseDto toDTO(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .shortDescription(product.getShortDescription())
                .brand(product.getBrand())
                .price(product.getPrice())
                .discountedPrice(product.getDiscountedPrice())
                .discountPercent(product.getDiscountPercent())
                .stockQuantity(product.getStockQuantity())
                .color(product.getColor())
                .sizes(product.getSizes())
                .mainImageUrl(product.getMainImageUrl())
                .galleryImages(product.getGalleryImages())
                .isAvailable(product.getIsAvailable())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .categoryItemId(product.getCategoryItem() != null ? product.getCategoryItem().getId() : null)
                .categoryItemName(product.getCategoryItem() != null ? product.getCategoryItem().getName() : null)
                .build();
    }
}
