package com.ecommerce.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private String shortDescription;
    private String brand;
    private BigDecimal price;
    private BigDecimal discountedPrice;
    private Integer discountPercent;
    private Integer stockQuantity;
    private String color;
    private Set<String> sizes;
    private String mainImageUrl;
    private List<String> galleryImages;
    private Boolean isAvailable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long categoryItemId;
    private String categoryItemName;

}
