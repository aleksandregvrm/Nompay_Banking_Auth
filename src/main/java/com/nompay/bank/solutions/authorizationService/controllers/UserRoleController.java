package com.nompay.bank.solutions.authorizationService.controllers;

import com.nompay.bank.grpc.*;
import com.nompay.bank.solutions.authorizationService.repositories.entities.RoleUsersEntity;
import com.nompay.bank.solutions.authorizationService.services.impl.UserRoleServiceImpl;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.apache.coyote.BadRequestException;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class UserRoleController extends UserRoleGrpc.UserRoleImplBase {
  private UserRoleServiceImpl userRoleService;

  public UserRoleController(UserRoleServiceImpl userRoleService) {
    this.userRoleService = userRoleService;
  }

  @Override
  public void createUserRole(CreateUserRoleRequest request, StreamObserver<CreateUserRoleResponse> responseObserver) {
    try {
      // This is the code that might throw an exception
      RoleUsersEntity roleUser = this.userRoleService.addUserRole(request.getUserId(), request.getRoleUser());

      // If the above line succeeds, this code will run to build the response
      CreateUserRoleResponse reply = CreateUserRoleResponse.newBuilder()
          .setId(roleUser.getId().toString())
          .setUserId(request.getUserId())
          .setRoleUser(UserRolesEnum.valueOf("ADMIN"))
          .build();

      responseObserver.onNext(reply);
      responseObserver.onCompleted();

    } catch (BadRequestException e) {
      // This block runs ONLY if a BadRequestException is thrown
      // You handle the error here, for example by sending a gRPC error response
      responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
    }
  }

  @Override
  public void deleteUserRole(DeleteUserRoleRequest request, StreamObserver<DeleteUserRoleResponse> responseObserver) {
    super.deleteUserRole(request, responseObserver);
  }
}
