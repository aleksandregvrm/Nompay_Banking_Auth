package com.nompay.bank.solutions.authorizationService.controllers;

import com.nompay.bank.grpc.*;
import com.nompay.bank.solutions.authorizationService.repositories.entities.AuthenticatedUsersEntity;
import com.nompay.bank.solutions.authorizationService.services.impl.UserAuthServiceImpl;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

import static java.lang.System.out;

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
    out.println("it has reached in here...");
//    AuthenticatedUsersEntity auth = authService.save(request.getUserId(), request.getEmail());
    UserAuthResponse reply = UserAuthResponse.newBuilder()
        .setId("1231231123")
        .setUserId("12312312")
        .setEmail("chukula@com.com")
        .setIsAuthenticated(true)
        .build();
    out.println(reply);
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
