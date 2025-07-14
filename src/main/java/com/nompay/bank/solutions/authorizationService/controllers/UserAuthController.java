package com.nompay.bank.solutions.authorizationService.controllers;

import com.nompay.bank.grpc.*;
import com.nompay.bank.solutions.authorizationService.repositories.dto.UserAuth;
import com.nompay.bank.solutions.authorizationService.services.impl.UserAuthServiceImpl;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class UserAuthController extends UserAuthenticatorGrpc.UserAuthenticatorImplBase {
  private final UserAuthServiceImpl authService;

  public UserAuthController(UserAuthServiceImpl authService) {
    this.authService = authService;
  }

  @Override
  public void createUserAuth(
      UserAuthRequest request,
      StreamObserver<UserAuthResponse> responseObserver
  ) {
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

  @Override
  public void deleteUserAUth(DeleteUserAuthRequest request, StreamObserver<DeleteUserAuthResponse> responseObserver) throws StatusRuntimeException {
    String deletedUserAuth = authService.delete(request.getUserId());
    DeleteUserAuthResponse reply = DeleteUserAuthResponse.newBuilder().setMsg(deletedUserAuth).build();

    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }


}
