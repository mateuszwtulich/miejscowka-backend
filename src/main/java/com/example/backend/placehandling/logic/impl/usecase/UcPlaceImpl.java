package com.example.backend.placehandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.placehandling.dataaccess.api.dao.CategoryDao;
import com.example.backend.placehandling.dataaccess.api.dao.PlaceDao;
import com.example.backend.placehandling.dataaccess.api.dao.PlaceImageDao;
import com.example.backend.placehandling.dataaccess.api.entity.*;
import com.example.backend.placehandling.dataaccess.api.entity.PlaceEntity;
import com.example.backend.placehandling.logic.api.mapper.OpeningHoursMapper;
import com.example.backend.placehandling.logic.api.mapper.PlaceMapper;
import com.example.backend.placehandling.logic.api.to.PlaceCto;
import com.example.backend.placehandling.logic.api.to.PlaceTo;
import com.example.backend.placehandling.logic.api.usecase.UcPlace;
import com.example.backend.taskhandling.logic.impl.usecase.UcManageTaskImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class UcPlaceImpl implements UcPlace {

    private static final Logger LOG = LoggerFactory.getLogger(UcManageTaskImpl.class);
    private static final String ID_CANNOT_BE_NULL = "id cannot be a null value";
    private static final String CREATE_PLACE_LOG = "Create Place with name {} in database.";
    private static final String UPDATE_PLACE_LOG = "Update Place with id {} in database.";
    private static final String GET_PLACE_LOG = "Get Place with id {} from database.";
    private static final String GET_ALL_PLACES_LOG = "Get all Places from database.";
    private static final String DELETE_PLACE_LOG = "Delete Place with id {} in database.";

    @Inject
    private PlaceMapper placeMapper;
    
    @Inject
    private PlaceDao placeDao;

    @Inject
    private OpeningHoursMapper openingHoursMapper;

    @Inject
    private CategoryDao categoryDao;

    @Inject
    private PlaceImageDao placeImageDao;
    
    
    
    @Override
    public Optional<PlaceCto> createPlace(PlaceTo placeTo) throws EntityAlreadyExistsException, EntityDoesNotExistException {
        LOG.debug(CREATE_PLACE_LOG, placeTo.getName());
        PlaceEntity placeEntity = placeMapper.toPlaceEntity(placeTo);
        CategoryEntity categoryEntity = getCategoryById(placeTo.getCategoryId());
        placeEntity.setCategory(categoryEntity);

        updatePlaceImageEntity(placeEntity, placeTo.getImageUrl());

        placeEntity.setOpeningHours(openingHoursMapper.toOpeningHoursEntity(placeTo.getOpeningHoursTo()));

        PlaceEntity placeSaved = placeDao.save(placeEntity);
        return toPlaceCto(placeSaved);
    }

    @Override
    public Optional<PlaceCto> updatePlace(PlaceTo placeTo, Long placeId) throws EntityDoesNotExistException {
        LOG.debug(UPDATE_PLACE_LOG, placeId);
        PlaceEntity placeEntity = getPlaceById(placeId);
        placeEntity.setName(placeTo.getName());
        placeEntity.setDescription(placeTo.getDescription());

        CategoryEntity categoryEntity = getCategoryById(placeTo.getCategoryId());
        placeEntity.setCategory(categoryEntity);

        updatePlaceImageEntity(placeEntity, placeTo.getImageUrl());

        placeEntity.setOpeningHours(openingHoursMapper.toOpeningHoursEntity(placeTo.getOpeningHoursTo()));

        return toPlaceCto(placeEntity);
    }

    @Override
    public void deletePlace(Long placeId) throws EntityDoesNotExistException {
        LOG.debug(DELETE_PLACE_LOG, placeId);

        PlaceEntity placeEntity = getPlaceById(placeId);
        placeDao.deleteById(placeEntity.getId());
    }

    @Override
    public Optional<PlaceCto> findPlace(Long placeId) throws EntityDoesNotExistException {
        LOG.debug(GET_PLACE_LOG, placeId);
        Objects.requireNonNull(placeId, ID_CANNOT_BE_NULL);

        PlaceEntity placeEntity = getPlaceById(placeId);
        return toPlaceCto(placeEntity);
    }

    @Override
    public Optional<List<PlaceCto>> findAllPlaces() {
        LOG.debug(GET_ALL_PLACES_LOG);

        return Optional.of(placeDao.findAll().stream()
                .map(placeEntity -> placeMapper.toPlaceCto(placeEntity))
                .collect(Collectors.toList()));
    }

    private Optional<PlaceCto> toPlaceCto(PlaceEntity placeEntity){
        PlaceCto placeCto = placeMapper.toPlaceCto(placeEntity);
        return Optional.of(placeCto);
    }

    private PlaceEntity getPlaceById(Long placeId) throws EntityDoesNotExistException{
        Objects.requireNonNull(placeId, ID_CANNOT_BE_NULL);

        return placeDao.findById(placeId).orElseThrow(() ->
                new EntityDoesNotExistException("Place with id " + placeId + " does not exists"));
    }

    private CategoryEntity getCategoryById(Long categoryId) throws EntityDoesNotExistException{
        Objects.requireNonNull(categoryId, ID_CANNOT_BE_NULL);

        return categoryDao.findById(categoryId).orElseThrow(() ->
                new EntityDoesNotExistException("Category with id " + categoryId + " does not exists"));
    }

    private void updatePlaceImageEntity(PlaceEntity placeEntity, String imageUrl){

        List<PlaceImageEntity> images = placeImageDao.findAllByPlace_Id(placeEntity.getId());
        if(images.stream().anyMatch(o -> o.getUrl().equals(imageUrl))){
            //imageUrl already exists
            //do nothing
        }else {
            //imageUrl doesn't exist
            PlaceImageEntity placeImageEntity = new PlaceImageEntity(placeEntity, imageUrl);
            List<PlaceImageEntity> placeImages = placeEntity.getPlaceImages();
            placeImages.add(placeImageEntity);
            placeEntity.setPlaceImages(placeImages);
        }

    }


}
