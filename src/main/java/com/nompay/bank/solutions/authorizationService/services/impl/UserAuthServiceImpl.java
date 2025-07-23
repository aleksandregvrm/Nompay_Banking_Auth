package com.nompay.bank.solutions.authorizationService.services.impl;

import com.nompay.bank.solutions.authorizationService.repositories.entities.AuthenticatedUsersEntity;
import com.nompay.bank.solutions.authorizationService.repositories.entities.jpa.AuthenticatedUserEntityJpa;
import com.nompay.bank.solutions.authorizationService.services.UserAuthService;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class UserAuthServiceImpl implements UserAuthService {

  private final Logger loggerMessage = Logger.getLogger(UserAuthServiceImpl.class.getName());

  private AuthenticatedUserEntityJpa authenticatedUserEntity;

  public UserAuthServiceImpl(AuthenticatedUserEntityJpa authenticatedUserEntity) {
    this.authenticatedUserEntity = authenticatedUserEntity;
  }

  @Override
  public AuthenticatedUsersEntity save(long userId, String email) {
    AuthenticatedUsersEntity authEntity = new AuthenticatedUsersEntity();
    authEntity.setUserId(userId);
    authEntity.setEmail(email);
    authEntity.setAuthenticated(true);
    try {
      this.authenticatedUserEntity.save(authEntity);
      return authEntity;
    } catch (ValidationException exception) {
      throw exception;
    }
  }

  @Override
  public String delete(long userId) {

    return "User Auth Deleted";
  }
}
