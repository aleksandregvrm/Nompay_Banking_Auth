package com.nompay.bank.solutions.authorizationService.repositories.entities;

import com.nompay.bank.solutions.authorizationService.repositories.enums.RoleUser;
import jakarta.persistence.*;

@Entity
@Table(
    name = "role_user"
)
public class RoleUsersEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  /**
   * This Refers to user which will be assigned
   * to him and it will be stored in the db...
   */
  @OneToOne(optional = false)
  @JoinColumn(name = "authenticated_user_id", referencedColumnName = "id", nullable = false)
  private AuthenticatedUsersEntity authenticatedUserId;

  @Enumerated(EnumType.STRING)
  @Column(name = "authenticated_user_role", nullable = false)
  private RoleUser role;

  public Long getId() {
    return id;
  }

  public AuthenticatedUsersEntity getAuthenticatedUserId() {
    return authenticatedUserId;
  }

  public RoleUser getRole() {
    return role;
  }

  public void setAuthenticatedUserId(AuthenticatedUsersEntity authenticatedUserId) {
    this.authenticatedUserId = authenticatedUserId;
  }

  public void setRole(RoleUser role) {
    this.role = role;
  }
}
