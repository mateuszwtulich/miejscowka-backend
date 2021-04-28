package com.example.backend.userhandling.logic.api.mapper;

import com.example.backend.userhandling.dataaccess.api.entity.PermissionEntity;
import com.example.backend.userhandling.logic.api.to.PermissionEto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-28T20:42:10+0200",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 15 (Oracle Corporation)"
)
@Component
public class PermissionsMapperImpl implements PermissionsMapper {

    @Override
    public PermissionEto toPermissionEto(PermissionEntity permissionEntity) {
        if ( permissionEntity == null ) {
            return null;
        }

        PermissionEto permissionEto = new PermissionEto();

        permissionEto.setId( permissionEntity.getId() );
        permissionEto.setName( permissionEntity.getName() );
        permissionEto.setDescription( permissionEntity.getDescription() );

        return permissionEto;
    }
}
