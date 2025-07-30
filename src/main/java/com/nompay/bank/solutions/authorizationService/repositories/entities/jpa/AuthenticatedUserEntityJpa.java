package com.nompay.bank.solutions.authorizationService.repositories.entities.jpa;

import com.nompay.bank.solutions.authorizationService.repositories.entities.AuthenticatedUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticatedUserEntityJpa extends JpaRepository<AuthenticatedUsersEntity, Long> {

  long deleteByUserId(long userId);

  Optional<AuthenticatedUsersEntity> getUserByUserId(long userId);
}
