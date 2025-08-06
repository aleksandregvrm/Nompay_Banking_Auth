package com.nompay.bank.solutions.authorizationService.repositories.enums;

public enum RoleUser {
  USER(1, "USER"),
  ADMIN(2, "ADMIN");

  private final int roleCode;
  private final String role;

  RoleUser(int roleCode, String role) {
    this.roleCode = roleCode;
    this.role = role;
  }

  public String getRole() {
    return this.role;
  }

  public int getRoleCode() {
    return this.roleCode;
  }
}