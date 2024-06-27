package com.nguyeen.identity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nguyeen.identity.dto.request.RoleRequest;
import com.nguyeen.identity.dto.response.RoleResponse;
import com.nguyeen.identity.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
