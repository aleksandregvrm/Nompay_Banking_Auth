package com.nompay.bank.solutions.authorizationService.services;

import com.nompay.bank.solutions.authorizationService.repositories.dto.UserAuth;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserAuthService {
  public UserAuth save(String userId, String email){
    return new UserAuth(UUID.randomUUID().toString(), userId, email, true);
  }

  public void delete(String userId){
    // TODO!!!
  }
}
