package com.brayancoronado.store.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@JsonPropertyOrder({
        "saleId",
        "saleDate",
        "total",
        "statusSale",
        "customer",
        "user"
})
@Entity
@Table(name = "Sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Integer saleId;

    @NotNull(message = "Date is required.")
    @Column(name = "sale_date")
    private LocalDate saleDate;

    @NotNull(message = "Total is required.")
    @Column(name = "total")
    private Double total;

    @NotNull(message = "Status is required.")
    @Column(name = "status_sale")
    private Integer statusSale;

    @ManyToOne
    @JoinColumn(name = "customers_customer_id")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "users_user_id")
    private Users user;

    // Getter y setters

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getStatusSale() {
        return statusSale;
    }

    public void setStatusSale(Integer statusSale) {
        this.statusSale = statusSale;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}