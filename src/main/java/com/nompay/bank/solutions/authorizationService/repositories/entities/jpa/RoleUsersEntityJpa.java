package com.nompay.bank.solutions.authorizationService.repositories.entities.jpa;

import com.nompay.bank.solutions.authorizationService.repositories.entities.RoleUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUsersEntityJpa extends JpaRepository<RoleUsersEntity, Long> {

}
