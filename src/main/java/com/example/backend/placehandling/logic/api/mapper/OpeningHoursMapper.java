package com.example.backend.placehandling.logic.api.mapper;

import com.example.backend.placehandling.dataaccess.api.entity.OpeningHoursEntity;
import com.example.backend.placehandling.logic.api.to.OpeningHoursTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OpeningHoursMapper {
    OpeningHoursEntity toOpeningHoursEntity(OpeningHoursTo openingHoursTo);

}
