package com.nompay.bank.solutions.authorizationService.services.impl;

import com.nompay.bank.solutions.authorizationService.repositories.entities.RoleUsersEntity;
import com.nompay.bank.solutions.authorizationService.repositories.entities.jpa.AuthenticatedUserEntityJpa;
import com.nompay.bank.solutions.authorizationService.repositories.enums.RoleUser;
import com.nompay.bank.solutions.authorizationService.services.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

  private final AuthenticatedUserEntityJpa authenticatedUserRepository;

  public UserRoleServiceImpl(AuthenticatedUserEntityJpa authenticatedUserRepository) {
    this.authenticatedUserRepository = authenticatedUserRepository;
  }


  @Override
  public RoleUsersEntity addUserRole(String userId, RoleUser roleUser) {
    return null;
  }

  @Override
  public String deleteUserRole(String userId) {
    return "";
  }
}
