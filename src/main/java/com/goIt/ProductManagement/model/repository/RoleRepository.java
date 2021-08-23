package com.goIt.ProductManagement.model.repository;

import com.goIt.ProductManagement.model.entity.Role;
import com.goIt.ProductManagement.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface RoleRepository extends JpaRepository<Role, UUID> {

    Role findByRole(UserRole role);

}
