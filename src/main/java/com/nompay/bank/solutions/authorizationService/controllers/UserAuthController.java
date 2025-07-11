package com.nompay.bank.solutions.authorizationService.controllers;

import com.nompay.bank.grpc.UserAuthRequest;
import com.nompay.bank.grpc.UserAuthResponse;
import com.nompay.bank.grpc.UserAuthenticatorGrpc;
import com.nompay.bank.solutions.authorizationService.repositories.dto.UserAuth;
import com.nompay.bank.solutions.authorizationService.services.UserAuthService;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class UserAuthController extends UserAuthenticatorGrpc.UserAuthenticatorImplBase {
  private final UserAuthService authService;

  public UserAuthController(UserAuthService authService) {
    this.authService = authService;
  }

  @Override
  public void createUserAuth(
      UserAuthRequest request,
      StreamObserver<UserAuthResponse> responseObserver
  ){
    UserAuth auth = authService.save(request.getUserId(), request.getEmail());

    UserAuthResponse reply = UserAuthResponse.newBuilder()
        .setId(auth.id())
        .setUserId(auth.userId())
        .setEmail(auth.email())
        .setIsAuthenticated(auth.isAuthenticated())
        .build();

    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
