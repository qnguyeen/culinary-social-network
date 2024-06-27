package com.nguyeen.identity.mapper;

import org.mapstruct.Mapper;

import com.nguyeen.identity.dto.request.PermissionRequest;
import com.nguyeen.identity.dto.response.PermissionResponse;
import com.nguyeen.identity.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
