package com.nompay.bank.solutions.authorizationService.repositories.entities;

import jakarta.persistence.*;

import java.util.Date; // Using java.util.Date for TemporalType.TIMESTAMP

@Entity
@Table(
    name = "authenticated_users"
)
public class AuthenticatedUsersEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "user_id", nullable = false, unique = true) // Assuming userId should be unique and not null
  private Long userId;

  @Column(name = "email", nullable = false, unique = true) // Assuming email should be unique and not null
  private String email;

  @Column(name = "is_authenticated", nullable = false) // Explicit column name
  private boolean isAuthenticated;

  @Column(name = "create_date", updatable = false, nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createDate;

  @Column(name = "update_date", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateDate;

  // --- Constructors ---
  public AuthenticatedUsersEntity() {
    // Default constructor
  }

  // --- Lifecycle Callbacks for Dates ---
  @PrePersist
  protected void onCreate() {
    createDate = new Date();
    updateDate = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updateDate = new Date();
  }

  // --- Getters and Setters ---
  public Long getId() {
    return id;
  }

  // No setId() for auto-generated ID

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean getIsAuthenticated() { // Changed to getIsAuthenticated for boolean property convention
    return isAuthenticated;
  }

  public void setIsAuthenticated(boolean authenticated) { // Changed to setIsAuthenticated
    isAuthenticated = authenticated;
  }

  public Date getCreateDate() {
    return createDate;
  }

  // No setCreateDate() as it's managed by @PrePersist

  public Date getUpdateDate() {
    return updateDate;
  }

  // No setUpdateDate() as it's managed by @PreUpdate

  @Override
  public String toString() {
    return "AuthenticatedUsersEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", email='" + email + '\'' +
        ", isAuthenticated=" + isAuthenticated +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        '}';
  }
}
