package com.ecommerce.category.model;

import com.ecommerce.category.model.enums.SizeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Size {

    @Enumerated(EnumType.STRING)
    @Column(name = "size_name")
    private SizeType name;

    @Column(name = "quantity")
    private int quantity;
}
