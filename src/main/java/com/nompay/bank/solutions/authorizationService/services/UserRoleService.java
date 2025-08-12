package com.nompay.bank.solutions.authorizationService.services;

import com.nompay.bank.solutions.authorizationService.repositories.entities.RoleUsersEntity;
import com.nompay.bank.solutions.authorizationService.repositories.enums.RoleUser;

public interface UserRoleService {
  RoleUsersEntity addUserRole(String userId, RoleUser roleUser);

  String deleteUserRole(String userId);
}
