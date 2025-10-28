package com.ecommerce.category.model;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class PaymentInformation {

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cardholder_number")
    private String cardholderName;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "cvv")
    private String cvv;
}
