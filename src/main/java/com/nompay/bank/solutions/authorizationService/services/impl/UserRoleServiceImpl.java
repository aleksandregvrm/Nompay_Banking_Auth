package com.nompay.bank.solutions.authorizationService.services.impl;

import com.nompay.bank.grpc.UserRolesEnum;
import com.nompay.bank.solutions.authorizationService.repositories.entities.AuthenticatedUsersEntity;
import com.nompay.bank.solutions.authorizationService.repositories.entities.RoleUsersEntity;
import com.nompay.bank.solutions.authorizationService.repositories.entities.jpa.AuthenticatedUserEntityJpa;
import com.nompay.bank.solutions.authorizationService.repositories.entities.jpa.RoleUsersEntityJpa;
import com.nompay.bank.solutions.authorizationService.services.UserRoleService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserRoleServiceImpl implements UserRoleService {
  private static final Logger loggerMessage = Logger.getLogger(UserRoleServiceImpl.class.getName());
  private final AuthenticatedUserEntityJpa authenticatedUserRepository;
  private final RoleUsersEntityJpa roleUserRepository;

  public UserRoleServiceImpl(AuthenticatedUserEntityJpa authenticatedUserRepository, RoleUsersEntityJpa roleUserRepository) {
    this.authenticatedUserRepository = authenticatedUserRepository;
    this.roleUserRepository = roleUserRepository;
  }


  @Override
  public RoleUsersEntity addUserRole(String userId, UserRolesEnum roleUser) throws BadRequestException {

    Optional<AuthenticatedUsersEntity> authenticatedUser = this.authenticatedUserRepository.getUserByUserId(Integer.parseInt(userId));
    if (authenticatedUser.isEmpty()) {
      throw new BadRequestException("No such authenticated user found with user id " + userId);
    }

    Optional<RoleUsersEntity> alreadySetRoleUser = authenticatedUser.get().getUserRole();
    if (alreadySetRoleUser.isPresent()) {
      throw new BadRequestException("User role has already been set for user id " + userId);
    }

    return null;
  }

  @Override
  public String deleteUserRole(String userId) {
    return "";
  }
}
