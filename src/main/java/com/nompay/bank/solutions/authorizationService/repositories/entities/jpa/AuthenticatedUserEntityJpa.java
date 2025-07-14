package com.nompay.bank.solutions.authorizationService.repositories.entities.jpa;

import com.nompay.bank.solutions.authorizationService.repositories.entities.AuthenticatedUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticatedUserEntityJpa extends JpaRepository<AuthenticatedUsersEntity, Long> {
}
