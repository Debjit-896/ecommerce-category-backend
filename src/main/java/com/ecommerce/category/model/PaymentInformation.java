package com.ecommerce.category.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_information")
public class PaymentInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cardholder_number")
    private String cardholderName;

    @Column(name = "card_brand")
    private String cardBrand; // e.g. Visa, Mastercard

    @Column(name = "expiry_month_year")
    private String expiryMonthYear; // e.g. "08/2028"

    @Column(name = "cvv")
    private String cvv;

    // Relationship mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
