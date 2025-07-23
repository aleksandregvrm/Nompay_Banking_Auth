package com.nompay.bank.solutions.authorizationService.repositories.dto;

public record UserAuth(String userId, String email, boolean isAuthenticated) {
}
