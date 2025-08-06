package com.nompay.bank.solutions.authorizationService.repositories.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(
    name = "user_sessions"
)
public class UserSessionsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "token", updatable = true, nullable = true)
  private String token;

  @Column(name = "session_length_ms")
  private String sessionLengthMs;

  @Column(name = "session_valid_till")
  private Date sessionValidTill;

  @OneToOne(optional = false)
  @JoinColumn(name = "authenticated_user_id", referencedColumnName = "id")
  private AuthenticatedUsersEntity authenticatedUserId;

  public UserSessionsEntity() {
  }

  public void setAuthenticatedUserId(AuthenticatedUsersEntity authenticatedUserId) {
    this.authenticatedUserId = authenticatedUserId;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setSessionLengthMs(String sessionLengthMs) {
    this.sessionLengthMs = sessionLengthMs;
  }

  public void setSessionValidTill(Date sessionValidTill) {
    this.sessionValidTill = sessionValidTill;
  }

  public Long getId() {
    return id;
  }

  public String getToken() {
    return token;
  }

  public String getSessionLengthMs() {
    return sessionLengthMs;
  }

  public Date getSessionValidTill() {
    return sessionValidTill;
  }

  public AuthenticatedUsersEntity getAuthenticatedUserId() {
    return authenticatedUserId;
  }

  @Override
  public String toString() {
    return "UserSessionsEntity{" +
        "id=" + id +
        ", token='" + token + '\'' +
        ", sessionLengthMs='" + sessionLengthMs + '\'' +
        ", sessionValidTill=" + sessionValidTill +
        ", authenticatedUserId=" + authenticatedUserId +
        '}';
  }
}
