package com.ecommerce.category.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name; // e.g. "Electronics", "Men's Clothing"

    @Column(length = 255)
    private String description; // Optional: short info about the category

    private String imageUrl; // For category banner/image (used in frontend)

    @Column(nullable = false)
    private Boolean active = true; // Soft disable category if needed

    @Column(updatable = false)
    private LocalDateTime createdAt; // Auto-filled at creation

    private LocalDateTime updatedAt; // Updated when modified

    // Relationship mapping
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryType> categoryTypes = new ArrayList<>();


    // Lifecycle Callbacks
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
