package com.example.backend.placehandling.logic.impl;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.placehandling.logic.api.PlaceHandling;
import com.example.backend.placehandling.logic.api.to.CategoryEto;
import com.example.backend.placehandling.logic.api.to.CategoryTo;
import com.example.backend.placehandling.logic.api.to.PlaceCto;
import com.example.backend.placehandling.logic.api.to.PlaceTo;
import com.example.backend.placehandling.logic.api.usecase.UcCategory;
import com.example.backend.placehandling.logic.api.usecase.UcPlace;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlaceHandlingImpl implements PlaceHandling {

    @Inject
    private UcCategory ucCategory;

    @Inject UcPlace ucPlace;

    @Override
    public Optional<CategoryEto> createCategory(CategoryTo categoryTo) throws EntityAlreadyExistsException {
        return ucCategory.createCategory(categoryTo);
    }

    @Override
    public Optional<CategoryEto> updateCategory(CategoryTo categoryTo, Long categoryId) throws EntityDoesNotExistException {
        return ucCategory.updateCategory(categoryTo, categoryId);
    }

    @Override
    public void deleteCategory(Long categoryId) throws EntityDoesNotExistException {
        ucCategory.deleteCategory(categoryId);
    }

    @Override
    public Optional<CategoryEto> findCategory(Long categoryId) throws EntityDoesNotExistException {
        return ucCategory.findCategory(categoryId);
    }

    @Override
    public Optional<List<CategoryEto>> findAllCategories() {
        return ucCategory.findAllCategories();
    }

    @Override
    public Optional<PlaceCto> createPlace(PlaceTo placeTo) throws EntityAlreadyExistsException, EntityDoesNotExistException {
        return ucPlace.createPlace(placeTo);
    }

    @Override
    public Optional<PlaceCto> updatePlace(PlaceTo placeTo, Long placeId) throws EntityDoesNotExistException {
        return ucPlace.updatePlace(placeTo, placeId);
    }

    @Override
    public void deletePlace(Long placeId) throws EntityDoesNotExistException {
        ucPlace.deletePlace(placeId);
    }

    @Override
    public Optional<PlaceCto> findPlace(Long placeId) throws EntityDoesNotExistException {
        return ucPlace.findPlace(placeId);
    }

    @Override
    public Optional<List<PlaceCto>> findFavouritePlaces(Long userId) {
        return ucPlace.findFavouritePlaces(userId);
    }

    @Override
    public Optional<List<PlaceCto>> findAllPlaces() {
        return ucPlace.findAllPlaces();
    }

    @Override
    public Optional<List<PlaceCto>> findAllPlaces(Long userId) {
        return ucPlace.findAllPlaces(userId);
    }

    @Override
    public Optional<PlaceCto> setPlaceFavourite(Long placeId, Long userId, Boolean isFavourite) throws EntityDoesNotExistException {
        return ucPlace.setPlaceFavourite(placeId, userId, isFavourite);
    }
}
