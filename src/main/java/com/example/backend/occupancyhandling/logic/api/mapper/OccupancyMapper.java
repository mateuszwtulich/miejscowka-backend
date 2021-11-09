package com.example.backend.occupancyhandling.logic.api.mapper;

import com.example.backend.occupancyhandling.dataaccess.api.entity.OccupancyEntity;
import com.example.backend.occupancyhandling.logic.api.to.OccupancyTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OccupancyMapper {
    OccupancyEntity toOccupancyEntity(OccupancyTo occupancyTo);
}
