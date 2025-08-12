package com.nompay.bank.solutions.authorizationService.services;

import com.nompay.bank.grpc.UserRolesEnum;
import com.nompay.bank.solutions.authorizationService.repositories.entities.RoleUsersEntity;
import org.apache.coyote.BadRequestException;

public interface UserRoleService {
  RoleUsersEntity addUserRole(String userId, UserRolesEnum roleUser) throws BadRequestException;

  String deleteUserRole(String userId);
}
