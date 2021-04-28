package com.example.backend.userhandling.logic.api.mapper;

import com.example.backend.userhandling.dataaccess.api.entity.PermissionEntity;
import com.example.backend.userhandling.logic.api.to.PermissionEto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionsMapper {
  PermissionEto toPermissionEto(PermissionEntity permissionEntity);
}
