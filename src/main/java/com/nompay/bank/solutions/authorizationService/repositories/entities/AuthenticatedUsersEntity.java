package com.nompay.bank.solutions.authorizationService.repositories.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(
    name = "authenticated_users"
)
public class AuthenticatedUsersEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private Long userId;

  @Column
  private String email;

  @Column
  private boolean isAuthenticated;

  @Column(name = "create_date", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createDate;

  @Column(name = "update_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateDate;


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

  public boolean isAuthenticated() {
    return isAuthenticated;
  }

  public void setAuthenticated(boolean authenticated) {
    isAuthenticated = authenticated;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public Long getId() {
    return id;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
}
