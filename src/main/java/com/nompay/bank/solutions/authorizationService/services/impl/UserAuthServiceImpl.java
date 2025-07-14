package com.nompay.bank.solutions.authorizationService.services.impl;

import com.nompay.bank.solutions.authorizationService.repositories.dto.UserAuth;
import com.nompay.bank.solutions.authorizationService.repositories.entities.jpa.AuthenticatedUserEntityJpa;
import com.nompay.bank.solutions.authorizationService.services.UserAuthService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;


@Service
public class UserAuthServiceImpl implements UserAuthService {

  private final Logger loggerMessage = Logger.getLogger(UserAuthServiceImpl.class.getName());

  private final static List<UserAuth> userAuthsList = new ArrayList<>();

  private AuthenticatedUserEntityJpa authenticatedUserEntity;

  public UserAuthServiceImpl(AuthenticatedUserEntityJpa authenticatedUserEntity) {
    this.authenticatedUserEntity = authenticatedUserEntity;
  }

  @Override
  public UserAuth save(String userId, String email) {
    UserAuth userAuth = new UserAuth(UUID.randomUUID().toString(), userId, email, true);
    UserAuthServiceImpl.userAuthsList.add(userAuth); // Adding the user auth to the list
    loggerMessage.info(() -> "User added to the list -" + userAuth);
    return new UserAuth(UUID.randomUUID().toString(), userId, email, true);
  }

  @Override
  public String delete(String userId) {

    UserAuthServiceImpl.userAuthsList.removeIf(auth -> Objects.equals(auth.userId(), userId));
    loggerMessage.info(() -> "Removed UserAuth with userId = " + userId + "; remaining records=" + userAuthsList.size()); // Logging the deletion...
    return "User Auth Deleted";
  }
}
