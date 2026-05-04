package com.brayancoronado.store.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@JsonPropertyOrder({
        "customerId",
        "firstName",
        "lastName",
        "address",
        "statusCustomer"
})
@Entity
@Table(name = "Customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @NotBlank(message = "First name is required.")
    @Size(max = 50, message = "First name must not exceed 50 characters.")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(max = 50, message = "Last name must not exceed 50 characters.")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Address is required.")
    @Size(max = 100, message = "Address must not exceed 100 characters.")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Status is required.")
    @Column(name = "status_customer")
    private Integer statusCustomer;

    // Getter y setters

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatusCustomer() {
        return statusCustomer;
    }

    public void setStatusCustomer(Integer statusCustomer) {
        this.statusCustomer = statusCustomer;
    }
}