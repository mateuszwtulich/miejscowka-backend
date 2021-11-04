package com.example.backend.placehandling.logic.api.mapper;

import com.example.backend.placehandling.dataaccess.api.entity.PlaceEntity;
import com.example.backend.placehandling.logic.api.to.PlaceCto;
import com.example.backend.placehandling.logic.api.to.PlaceTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceMapper {
    PlaceEntity toPlaceEntity(PlaceTo placeTo);
    PlaceCto toPlaceCto(PlaceEntity placeEntity);
}
