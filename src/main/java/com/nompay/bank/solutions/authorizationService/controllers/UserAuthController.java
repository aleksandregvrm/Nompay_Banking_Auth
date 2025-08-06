package com.nompay.bank.solutions.authorizationService.controllers;

import com.nompay.bank.grpc.*;
import com.nompay.bank.solutions.authorizationService.repositories.entities.AuthenticatedUsersEntity;
import com.nompay.bank.solutions.authorizationService.services.impl.UserAuthServiceImpl;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.System.out;

@GrpcService
public class UserAuthController extends UserAuthenticatorGrpc.UserAuthenticatorImplBase {
  private final UserAuthServiceImpl authService;

  public UserAuthController(UserAuthServiceImpl authService) {
    this.authService = authService;
  }

  @Override
  @Transactional
  public void createUserAuth(
      UserAuthRequest request,
      StreamObserver<UserAuthResponse> responseObserver
  ) {

    AuthenticatedUsersEntity auth = authService.save((long) Integer.parseInt(request.getUserId()), request.getEmail());
    UserAuthResponse reply = UserAuthResponse.newBuilder()
        .setId(auth.getId().toString())
        .setUserId(auth.getUserId().toString())
        .setEmail(auth.getEmail())
        .setIsAuthenticated(auth.getIsAuthenticated())
        .build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

  @Override
  @Transactional
  public void deleteUserAUth(DeleteUserAuthRequest request, StreamObserver<DeleteUserAuthResponse> responseObserver) throws StatusRuntimeException {
    String deletedUserAuth = authService.delete(request.getUserId());
    DeleteUserAuthResponse reply = DeleteUserAuthResponse.newBuilder().setMsg(deletedUserAuth).build();

    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }



}
