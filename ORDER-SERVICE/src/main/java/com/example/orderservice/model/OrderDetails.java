package com.example.orderservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "order_details")
@Data

public class OrderDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer orderId;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    private Integer userId;

    private Integer productId;

    private Integer quantity;

    private Double unitPrice;

    private Double totalPrice;

    private String paymentMode;

    private String paymentStatus;

    private String orderStatus;

    @Column(length = 500)
    private String shippingAddress;

    private LocalDateTime orderDate;

    private LocalDate expectedDelivery;

    private LocalDate deliveredDate;

    private String trackingNumber;

    @Column(length = 500)
    private String remarks;

}
