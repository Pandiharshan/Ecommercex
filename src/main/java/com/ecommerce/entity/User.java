package com.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "UserName is required")
    @Size(min=3, max=50, message="UserName must be between 3 and 50 characters")
    @Column(name="username", unique=true, nullable=false)
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name="email", unique=true, nullable=false)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min=6, max=100, message="Password must be at least 6 characters long")
    @Column(name="password", nullable=false)
    private String password;

    @NotNull(message = "First name is mandatory")
    @Size(min=2, max=50, message="First name must be between 2 and 50 characters")
    @Column(name="first_name", nullable=false)
    private String firstName;

    @NotNull(message = "Last name is mandatory")
    @Size(min=2, max=50, message="Last name must be between 2 and 50 characters")
    @Column(name="last_name", nullable=false)
    private String lastName;

    @NotNull(message = "Phone number is mandatory")
    @Size(min=10, max=15, message="Phone number must be between 10 and 15 characters")
    @Column(name="phone_number", nullable=false)
    private String phoneNumber;

    @NotNull(message = "Role is mandatory")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="created_at", nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @Column(name="updated_at", nullable=false)
    private LocalDateTime updatedAt;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Role enum
    public enum Role {
        ADMIN, USER
    }
}
