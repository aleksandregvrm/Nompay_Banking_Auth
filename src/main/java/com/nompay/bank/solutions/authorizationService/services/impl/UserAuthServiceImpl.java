package com.nompay.bank.solutions.authorizationService.services.impl;

import com.nompay.bank.solutions.authorizationService.repositories.entities.AuthenticatedUsersEntity;
import com.nompay.bank.solutions.authorizationService.repositories.entities.jpa.AuthenticatedUserEntityJpa;
import com.nompay.bank.solutions.authorizationService.services.UserAuthService;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

import java.util.Optional;
import java.util.logging.Logger;


@Service
public class UserAuthServiceImpl implements UserAuthService {

  private static final Logger loggerMessage = Logger.getLogger(UserAuthServiceImpl.class.getName());

  private final AuthenticatedUserEntityJpa authenticatedUserEntity;

  public UserAuthServiceImpl(AuthenticatedUserEntityJpa authenticatedUserEntity) {
    this.authenticatedUserEntity = authenticatedUserEntity;
  }

  /**
   * User Auth creation Just when the user has logged in...
   **/
  @Override
  public AuthenticatedUsersEntity save(long userId, String email) {
    AuthenticatedUsersEntity authEntity = new AuthenticatedUsersEntity();
    authEntity.setUserId(userId);
    authEntity.setEmail(email);
    authEntity.setIsAuthenticated(true);
    try {
      this.authenticatedUserEntity.save(authEntity);
      return authEntity;
    } catch (Exception exception) {
      out.print(exception + "Encountered Exception...");
      throw new StatusRuntimeException(Status.ALREADY_EXISTS);
    }
  }

  /**
   * User Auth deletion when user Authentication session is over
   **/
  @Override
  public String delete(long userId) {
    Optional<AuthenticatedUsersEntity> userAuth = this.authenticatedUserEntity.getUserByUserId(userId);
    if (userAuth.isEmpty()) { // Validation making sure that userAuth exists
      loggerMessage.warning("User with ID " + userId + " not found for deletion");
      throw new StatusRuntimeException(Status.NOT_FOUND.withDescription("User with ID " + userId + " not found for deletion"));
    }

    try {
      this.authenticatedUserEntity.deleteByUserId(userId);
      return "User Auth Deleted";
    } catch (Exception exception) {
      out.print(exception + "exception thrown");
      throw new StatusRuntimeException(Status.INVALID_ARGUMENT);
    }
  }
}
