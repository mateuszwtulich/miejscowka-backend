package com.example.backend.userhandling.logic.api.mapper;

import com.example.backend.userhandling.dataaccess.api.entity.RoleEntity;
import com.example.backend.userhandling.logic.api.to.RoleEto;
import com.example.backend.userhandling.logic.api.to.RoleTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
  RoleEntity toRoleEntity(RoleTo roleTo);

  RoleEto toRoleEto(RoleEntity roleEntity);
}
