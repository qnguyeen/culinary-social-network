package com.nguyeen.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyeen.identity.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
