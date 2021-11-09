package com.example.backend.placehandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.occupancyhandling.dataaccess.api.dao.OccupancyDao;
import com.example.backend.occupancyhandling.dataaccess.api.entity.OccupancyEntity;
import com.example.backend.occupancyhandling.logic.api.to.OccupancyTo;
import com.example.backend.placehandling.dataaccess.api.dao.CategoryDao;
import com.example.backend.placehandling.dataaccess.api.dao.OpeningHoursDao;
import com.example.backend.placehandling.dataaccess.api.dao.PlaceDao;
import com.example.backend.placehandling.dataaccess.api.dao.PlaceImageDao;
import com.example.backend.placehandling.dataaccess.api.entity.*;
import com.example.backend.placehandling.dataaccess.api.entity.PlaceEntity;
import com.example.backend.placehandling.logic.api.mapper.OpeningHoursMapper;
import com.example.backend.placehandling.logic.api.mapper.PlaceMapper;
import com.example.backend.placehandling.logic.api.to.OpeningHoursTo;
import com.example.backend.placehandling.logic.api.to.PlaceCto;
import com.example.backend.placehandling.logic.api.to.PlaceTo;
import com.example.backend.placehandling.logic.api.usecase.UcPlace;
import com.example.backend.taskhandling.logic.impl.usecase.UcManageTaskImpl;
import com.example.backend.userhandling.dataaccess.api.dao.UserDao;
import com.example.backend.userhandling.dataaccess.api.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@Validated
@Named
public class UcPlaceImpl implements UcPlace {

    private static final Logger LOG = LoggerFactory.getLogger(UcManageTaskImpl.class);
    private static final String ID_CANNOT_BE_NULL = "id cannot be a null value";
    private static final String CREATE_PLACE_LOG = "Create Place with name {} in database.";
    private static final String UPDATE_PLACE_LOG = "Update Place with id {} in database.";
    private static final String GET_PLACE_LOG = "Get Place with id {} from database.";
    private static final String GET_FAVOURITE_PLACE_LOG = "Get Place for user with id {} from database.";
    private static final String GET_ALL_PLACES_LOG = "Get all Places from database.";
    private static final String GET_ALL_PLACES_WITH_USER_INFO_LOG = "Get all Places with user info from database.";
    private static final String SET_PLACE_FAVOURITE_LOG = "Set place with id {} favourite for user with id {}.";
    private static final String DELETE_PLACE_LOG = "Delete Place with id {} in database.";

    @Inject
    private PlaceMapper placeMapper;
    
    @Inject
    private PlaceDao placeDao;

    @Inject
    private OpeningHoursMapper openingHoursMapper;

    @Inject
    private OpeningHoursDao openingHoursDao;

    @Inject
    private CategoryDao categoryDao;

    @Inject
    private PlaceImageDao placeImageDao;

    @Inject
    private UserDao userDao;

    @Inject
    private OccupancyDao occupancyDao;
    
    
    @Override
    public Optional<PlaceCto> createPlace(PlaceTo placeTo) throws EntityAlreadyExistsException, EntityDoesNotExistException {
        LOG.debug(CREATE_PLACE_LOG, placeTo.getName());
        PlaceEntity placeEntity = placeMapper.toPlaceEntity(placeTo);
        CategoryEntity categoryEntity = getCategoryById(placeTo.getCategoryId());
        placeEntity.setCategory(categoryEntity);

        updatePlaceImageEntity(placeEntity, placeTo.getImageUrl());

        placeEntity.setOpeningHours(createOpeningHoursEntity(placeTo, placeEntity));

        placeDao.save(placeEntity);
        return Optional.of(toPlaceCto(placeEntity));
    }

    @Override
    public Optional<PlaceCto> updatePlace(PlaceTo placeTo, Long placeId) throws EntityDoesNotExistException {
        LOG.debug(UPDATE_PLACE_LOG, placeId);
        PlaceEntity placeEntity = getPlaceById(placeId);
        placeEntity.setName(placeTo.getName());
        placeEntity.setDescription(placeTo.getDescription());
        placeEntity.setCapacity(placeTo.getCapacity());
        placeEntity.setStreet(placeTo.getStreet());
        placeEntity.setBuildingNumber(placeTo.getBuildingNumber());
        placeEntity.setApartmentNumber(placeTo.getApartmentNumber());


        CategoryEntity categoryEntity = getCategoryById(placeTo.getCategoryId());
        placeEntity.setCategory(categoryEntity);

        updatePlaceImageEntity(placeEntity, placeTo.getImageUrl());

        OpeningHoursEntity openingHoursEntity = openingHoursMapper.toOpeningHoursEntity(placeTo.getOpeningHoursTo());
        if(!placeEntity.getOpeningHours().equals(openingHoursEntity)){
            placeEntity.setOpeningHours(createOpeningHoursEntity(placeTo, placeEntity));
        }

        return Optional.of(toPlaceCto(placeEntity));
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

        return Optional.of(toPlaceCto(placeEntity));
    }

    @Override
    public Optional<List<PlaceCto>> findFavouritePlaces(Long userId) {
        LOG.debug(GET_FAVOURITE_PLACE_LOG, userId);
        Objects.requireNonNull(userId, ID_CANNOT_BE_NULL);

        return Optional.of(placeDao.findAll().stream()
                .filter(placeEntity -> placeEntity.getUsers().stream().anyMatch(userEntity -> userEntity.getId().equals(userId)))
                .map(placeEntity -> toPlaceCto(placeEntity, userId))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<PlaceCto>> findAllPlaces() {
        LOG.debug(GET_ALL_PLACES_LOG);

        return Optional.of(placeDao.findAll().stream()
                .map(placeEntity -> toPlaceCto(placeEntity))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<PlaceCto>> findAllPlaces(Long userId) {
        LOG.debug(GET_ALL_PLACES_WITH_USER_INFO_LOG);

        return Optional.of(placeDao.findAll().stream()
                .map(placeEntity -> toPlaceCto(placeEntity, userId))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<PlaceCto> setPlaceFavourite(Long placeId, Long userId, Boolean isFavourite) throws EntityDoesNotExistException {
        LOG.debug(SET_PLACE_FAVOURITE_LOG, placeId, userId);

        PlaceEntity placeEntity = getPlaceById(placeId);
        UserEntity userEntity = getUserById(userId);

        if(isFavourite){
            placeEntity.getUsers().add(userEntity);
        }else {
            placeEntity.getUsers().remove(userEntity);
        }

        return Optional.of(toPlaceCto(placeEntity, userId));
    }

    private OpeningHoursEntity createOpeningHoursEntity(PlaceTo placeTo, PlaceEntity placeEntity){
        OpeningHoursEntity openingHoursEntity = new OpeningHoursEntity();
        openingHoursEntity.setPlaceId(placeEntity.getId());
        openingHoursEntity.setMondayOpeningHour(placeTo.getOpeningHoursTo().getMondayOpeningHour());
        openingHoursEntity.setMondayClosingHour(placeTo.getOpeningHoursTo().getMondayClosingHour());
        openingHoursEntity.setTuesdayOpeningHour(placeTo.getOpeningHoursTo().getTuesdayOpeningHour());
        openingHoursEntity.setTuesdayClosingHour(placeTo.getOpeningHoursTo().getTuesdayClosingHour());
        openingHoursEntity.setWednesdayOpeningHour(placeTo.getOpeningHoursTo().getWednesdayOpeningHour());
        openingHoursEntity.setWednesdayClosingHour(placeTo.getOpeningHoursTo().getWednesdayClosingHour());
        openingHoursEntity.setThursdayOpeningHour(placeTo.getOpeningHoursTo().getThursdayOpeningHour());
        openingHoursEntity.setThursdayClosingHour(placeTo.getOpeningHoursTo().getThursdayClosingHour());
        openingHoursEntity.setFridayOpeningHour(placeTo.getOpeningHoursTo().getFridayOpeningHour());
        openingHoursEntity.setFridayClosingHour(placeTo.getOpeningHoursTo().getFridayClosingHour());
        openingHoursEntity.setSaturdayOpeningHour(placeTo.getOpeningHoursTo().getSaturdayOpeningHour());
        openingHoursEntity.setSaturdayClosingHour(placeTo.getOpeningHoursTo().getSaturdayClosingHour());
        openingHoursEntity.setSundayOpeningHour(placeTo.getOpeningHoursTo().getSundayOpeningHour());
        openingHoursEntity.setSundayClosingHour(placeTo.getOpeningHoursTo().getSundayClosingHour());
        openingHoursEntity.setPlace(placeEntity);
        OpeningHoursEntity savedOpening =  openingHoursDao.save(openingHoursEntity);

        return savedOpening;
    }

    private PlaceCto toPlaceCto(PlaceEntity placeEntity){
        return toPlaceCto(placeEntity, null);
    }

    private PlaceCto toPlaceCto(PlaceEntity placeEntity, Long userId){
        PlaceCto placeCto = placeMapper.toPlaceCto(placeEntity);

        placeCto.setCategoryName( placeEntity.getCategory().getName());
        if(!placeEntity.getPlaceImages().isEmpty())
            placeCto.setImageUrl(placeEntity.getPlaceImages().get(0).getUrl());
        placeCto.setOpeningHoursTo(toOpeningHoursTo(placeEntity.getOpeningHours()));

        if(userId != null && placeEntity.getUsers().stream().anyMatch(userEntity -> userEntity.getId().equals(userId))){
            placeCto.setFavourite(true);
        }else {
            placeCto.setFavourite(false);
        }

        //FIXME When it is uncommented there is a stack overflow
//        Optional<OccupancyEntity> occupancyEntityOpt = occupancyDao.findAll().stream().filter(occupancyEntity -> occupancyEntity.getId().getPlaceId().equals(placeEntity.getId())).findFirst();
//
//        if(occupancyEntityOpt.isPresent()){
//            OccupancyTo occupancyTo = new OccupancyTo();
//            occupancyTo.setNumber_of_people(occupancyEntityOpt.get().getNumber_of_people());
//            occupancyTo.setPercentage_occupancy(occupancyEntityOpt.get().getPercentage_occupancy());
//            placeCto.setLastOccupancyTo(occupancyTo);
//        }

        return placeCto;
    }

    private OpeningHoursTo toOpeningHoursTo(OpeningHoursEntity openingHoursEntity){
        OpeningHoursTo openingHoursTo = new OpeningHoursTo();
        openingHoursTo.setMondayOpeningHour(openingHoursEntity.getMondayOpeningHour());
        openingHoursTo.setMondayClosingHour(openingHoursEntity.getMondayClosingHour());
        openingHoursTo.setTuesdayOpeningHour(openingHoursEntity.getTuesdayOpeningHour());
        openingHoursTo.setTuesdayClosingHour(openingHoursEntity.getTuesdayClosingHour());
        openingHoursTo.setWednesdayOpeningHour(openingHoursEntity.getWednesdayOpeningHour());
        openingHoursTo.setWednesdayClosingHour(openingHoursEntity.getWednesdayClosingHour());
        openingHoursTo.setThursdayOpeningHour(openingHoursEntity.getThursdayOpeningHour());
        openingHoursTo.setThursdayClosingHour(openingHoursEntity.getThursdayClosingHour());
        openingHoursTo.setFridayOpeningHour(openingHoursEntity.getFridayOpeningHour());
        openingHoursTo.setFridayClosingHour(openingHoursEntity.getFridayClosingHour());
        openingHoursTo.setSaturdayOpeningHour(openingHoursEntity.getSaturdayOpeningHour());
        openingHoursTo.setSaturdayClosingHour(openingHoursEntity.getSaturdayClosingHour());
        openingHoursTo.setSundayOpeningHour(openingHoursEntity.getSundayOpeningHour());
        openingHoursTo.setSundayClosingHour(openingHoursEntity.getSundayClosingHour());
        return openingHoursTo;
    }

    private PlaceEntity getPlaceById(Long placeId) throws EntityDoesNotExistException{
        Objects.requireNonNull(placeId, ID_CANNOT_BE_NULL);

        return placeDao.findById(placeId).orElseThrow(() ->
                new EntityDoesNotExistException("Place with id " + placeId + " does not exists"));
    }

    private UserEntity getUserById(Long userId) throws EntityDoesNotExistException{
        Objects.requireNonNull(userId, ID_CANNOT_BE_NULL);

        return userDao.findById(userId).orElseThrow(() ->
                new EntityDoesNotExistException("User with id " + userId + " does not exists"));
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
            PlaceImageEntity placeImageEntity = new PlaceImageEntity();
            placeImageEntity.setUrl(imageUrl);
//            placeImageEntity.setPlace(placeEntity);
//            System.out.println(placeEntity.getPlaceImages().size());
//            placeImageDao.save(placeImageEntity);
            placeEntity.addPlaceImage(placeImageEntity);
        }

    }


}
