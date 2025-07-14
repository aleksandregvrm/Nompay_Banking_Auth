package com.nompay.bank.solutions.authorizationService.services;

import com.nompay.bank.solutions.authorizationService.repositories.dto.UserAuth;

public interface UserAuthService {
  UserAuth save(String userId, String email);
  String delete(String userId);
}
