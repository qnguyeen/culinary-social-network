package com.nguyeen.identity.mapper;

import com.nguyeen.identity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nguyeen.identity.dto.request.UserCreationRequest;
import com.nguyeen.identity.dto.request.UserUpdateRequest;
import com.nguyeen.identity.dto.response.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
