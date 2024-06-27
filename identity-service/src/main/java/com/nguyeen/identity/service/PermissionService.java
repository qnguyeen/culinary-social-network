package com.nguyeen.identity.service;

import java.util.List;

import com.nguyeen.identity.mapper.PermissionMapper;
import com.nguyeen.identity.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import com.nguyeen.identity.dto.request.PermissionRequest;
import com.nguyeen.identity.dto.response.PermissionResponse;
import com.nguyeen.identity.entity.Permission;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
