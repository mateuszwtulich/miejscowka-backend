package com.example.backend.placehandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.placehandling.logic.api.to.PlaceCto;
import com.example.backend.placehandling.logic.api.to.PlaceTo;

import java.util.List;
import java.util.Optional;

public interface UcPlace {

    Optional<PlaceCto> createPlace(PlaceTo placeTo) throws EntityAlreadyExistsException, EntityDoesNotExistException;
    Optional<PlaceCto> updatePlace(PlaceTo placeTo, Long placeId) throws EntityDoesNotExistException;
    void deletePlace(Long placeId) throws EntityDoesNotExistException;
    Optional<PlaceCto> findPlace(Long placeId) throws EntityDoesNotExistException;
    Optional<List<PlaceCto>> findFavouritePlaces(Long userId);
    Optional<List<PlaceCto>> findAllPlaces();
    Optional<List<PlaceCto>> findAllPlaces(Long userId);
    Optional<PlaceCto> setPlaceFavourite(Long placeId, Long userId, Boolean isFavourite) throws EntityDoesNotExistException;

}
