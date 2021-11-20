package com.example.backend.placehandling.service.impl;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.general.security.enums.ApplicationPermissions;
import com.example.backend.general.utils.annotations.PermissionRestrict;
import com.example.backend.placehandling.logic.api.to.CategoryEto;
import com.example.backend.placehandling.logic.api.to.CategoryTo;
import com.example.backend.placehandling.logic.api.to.PlaceCto;
import com.example.backend.placehandling.logic.api.to.PlaceTo;
import com.example.backend.placehandling.logic.impl.PlaceHandlingImpl;
import com.example.backend.placehandling.service.api.ui.PlaceRestService;
import com.example.backend.userhandling.logic.api.exception.AccountAlreadyExistsException;
import com.example.backend.userhandling.logic.api.exception.RoleHasAssignedUsersException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.inject.Inject;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PlaceRestServiceImpl implements PlaceRestService {
    private static String PLACE_NOT_EXIST = "Place do not exist.";
    private static String CATEGORY_NOT_EXIST = "Category do not exist.";

    @Inject
    private PlaceHandlingImpl placeHandling;

    @Override
    public List<PlaceCto> getAllPlaces() {
        return placeHandling.findAllPlaces().map( placeCtos -> {
            if(placeCtos.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, PLACE_NOT_EXIST);
            }
            return placeCtos;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public List<PlaceCto> getAllPlacesWithUserInfo(Long userId) {
        return placeHandling.findAllPlaces(userId).map( placeCtos -> {
            if(placeCtos.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, PLACE_NOT_EXIST);
            }
            return placeCtos;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public ResponseEntity<PlaceCto> getPlace(Long id) {
        try {
            return ResponseEntity
                    .ok()
                    .body(placeHandling.findPlace(id).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public List<CategoryEto> getAllCategories() {
        return placeHandling.findAllCategories().map( categoryEtos -> {
            if(categoryEtos.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, CATEGORY_NOT_EXIST);
            }
            return categoryEtos;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public List<PlaceCto> getAllFavouritePlaces(Long userId) {
        return placeHandling.findFavouritePlaces(userId).map( placeCtos -> {
            if(placeCtos.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, PLACE_NOT_EXIST);
            }
            return placeCtos;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
//    @PermissionRestrict(permissions = {ApplicationPermissions.ADD_PLACE})
    public ResponseEntity<PlaceCto> createPlace(PlaceTo placeTo) {
        try {
            return ResponseEntity
                    .created(new URI("/place"))
                    .body(placeHandling.createPlace(placeTo).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityAlreadyExistsException | URISyntaxException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    @PermissionRestrict(permissions = {ApplicationPermissions.ADD_CATEGORY})
    public ResponseEntity<CategoryEto> createCategory(CategoryTo categoryTo) {
        try {
            return ResponseEntity
                    .created(new URI("/category"))
                    .body(placeHandling.createCategory(categoryTo).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityAlreadyExistsException | URISyntaxException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<PlaceCto> addFavouritePlace(Long placeId, Long userId) {
        try {
            return ResponseEntity
                    .ok()
                    .body(placeHandling.setPlaceFavourite(placeId, userId, true).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<PlaceCto> removeFavouritePlace(Long placeId, Long userId) {
        try {
            return ResponseEntity
                    .ok()
                    .body(placeHandling.setPlaceFavourite(placeId, userId, false).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
//    @PermissionRestrict(permissions = {ApplicationPermissions.EDIT_PLACE})
    public ResponseEntity<PlaceCto> updatePlace(Long id, PlaceTo placeTo) {
        try {
            return ResponseEntity
                    .ok()
                    .body(placeHandling.updatePlace(placeTo, id).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    @PermissionRestrict(permissions = {ApplicationPermissions.EDIT_CATEGORY})
    public ResponseEntity<CategoryEto> updateCategory(Long id, CategoryTo categoryTo) {
        try {
            return ResponseEntity
                    .ok()
                    .body(placeHandling.updateCategory(categoryTo, id).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
//    @PermissionRestrict(permissions = {ApplicationPermissions.DELETE_PLACE})
    public ResponseEntity<?> deletePlace(Long id) {
        try {
            placeHandling.deletePlace(id);
            return ResponseEntity.ok().build();
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    @PermissionRestrict(permissions = {ApplicationPermissions.DELETE_CATEGORY})
    public ResponseEntity<?> deleteCategory(Long id) {
        try {
            placeHandling.deleteCategory(id);
            return ResponseEntity.ok().build();
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
