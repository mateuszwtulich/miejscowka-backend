package com.example.backend.userhandling.dataaccess.api.dao;

import com.example.backend.userhandling.dataaccess.api.entity.PermissionEntity;
import com.example.backend.userhandling.dataaccess.api.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<RoleEntity, Long> {

  boolean existsByName(String name);
  boolean existsByPermissionsIn(List<PermissionEntity> permissionEntities);
}