package com.brayancoronado.store.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@JsonPropertyOrder({
        "saleDetailId",
        "quantity",
        "unitPrice",
        "subtotal",
        "product",
        "sale"
})
@Entity
@Table(name = "SaleDetails")
public class SaleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_detail_id")
    private Integer saleDetailId;

    @NotNull(message = "Quantity is required.")
    @Column(name = "quantity")
    private Integer quantity;

    @NotNull(message = "Unit price is required.")
    @Column(name = "unit_price")
    private Double unitPrice;

    @NotNull(message = "Subtotal is required.")
    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "products_product_id")
    private Products product;

    @ManyToOne
    @JoinColumn(name = "sales_sale_id")
    private Sales sale;

    // Getters y Setters

    public Integer getSaleDetailId() {
        return saleDetailId;
    }

    public void setSaleDetailId(Integer saleDetailId) {
        this.saleDetailId = saleDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
        this.sale = sale;
    }
}