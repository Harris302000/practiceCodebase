package com.example.productservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_master")
@Data
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer productid;

	private String name;

	private String category;

	private String team;

	private String league;

	private String playerName;

	private Integer jerseyNumber;

	private String season;

	private String size;

	private String color;

	private BigDecimal cost;

	private Integer stock;

	private String availability;

	private String imageUrl;

	private String description;

}
