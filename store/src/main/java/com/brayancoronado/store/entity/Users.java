package com.brayancoronado.store.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@JsonPropertyOrder({
        "userId",
        "username",
        "password_user",
        "email",
        "role_user",
        "status_user"
})
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank(message = "Username cannot be empty.")
    @Size(min = 4, max = 45, message = "Username must be between 4 and 45 characters.")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 6, max = 45, message = "Password must be at least 6 characters long.")
    @Column(name = "password_user")
    private String password_user;

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Please enter a valid email format.")
    @Size(max = 60)
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Role cannot be empty.")
    @Column(name = "role_user")
    private String role_user;

    @NotNull(message = "Status cannot be empty.")
    @Column(name = "status_user")
    private Integer status_user;

    // Getter y setters

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole_user() {
        return role_user;
    }

    public void setRole_user(String role_user) {
        this.role_user = role_user;
    }

    public Integer getStatus_user() {
        return status_user;
    }

    public void setStatus_user(Integer status_user) {
        this.status_user = status_user;
    }
}