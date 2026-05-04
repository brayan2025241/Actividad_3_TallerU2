package com.brayancoronado.store.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@JsonPropertyOrder({
        "productId",
        "productName",
        "price",
        "stock",
        "statusProduct"
})
@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @NotBlank(message = "Product name cannot be empty.")
    @Size(min = 2, max = 60, message = "Name must be between 2 and 60 characters.")
    @Column(name = "product_name")
    private String productName;

    @NotNull(message = "Price cannot be empty.")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0.")
    @Column(name = "price")
    private BigDecimal price;

    @NotNull(message = "Stock cannot be empty.")
    @Min(value = 0, message = "Stock cannot be negative.")
    @Column(name = "stock")
    private Integer stock;

    @NotNull(message = "Status cannot be empty.")
    @Column(name = "status_product")
    private Integer statusProduct;

    // Getter y Setters

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(Integer statusProduct) {
        this.statusProduct = statusProduct;
    }
}