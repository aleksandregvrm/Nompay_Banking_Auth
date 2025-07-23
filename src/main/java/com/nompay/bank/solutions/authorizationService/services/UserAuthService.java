package com.nompay.bank.solutions.authorizationService.services;

import com.nompay.bank.solutions.authorizationService.repositories.entities.AuthenticatedUsersEntity;

public interface UserAuthService {
  AuthenticatedUsersEntity save(long userId, String email);
  String delete(long userId);
}
