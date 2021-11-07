package com.example.backend.placehandling.service.api.ui;

import com.example.backend.general.common.api.RestService;
import com.example.backend.placehandling.logic.api.to.CategoryEto;
import com.example.backend.placehandling.logic.api.to.CategoryTo;
import com.example.backend.placehandling.logic.api.to.PlaceCto;
import com.example.backend.placehandling.logic.api.to.PlaceTo;
import com.example.backend.userhandling.logic.api.to.UserEto;
import com.example.backend.userhandling.logic.api.to.UserTo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping
public interface PlaceRestService extends RestService {


    @ApiOperation(value = "Get all places.", tags = {"place"}, response = PlaceCto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 204, message = "No content found"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/place", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    List<PlaceCto> getAllPlaces();

    @ApiOperation(value = "Get place by id.",
            tags = {"place"},
            response = PlaceCto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 204, message = "Entity not found"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/place/{id}",
            produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PlaceCto> getPlace(@PathVariable(value = "id") Long id);

    @ApiOperation(value = "Get all categories.", tags = {"category"}, response = CategoryEto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 204, message = "No content found"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/place/category", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    List<CategoryEto> getAllCategories();


    @ApiOperation(value = "Get all user's favourite places.", tags = {"place"}, response = PlaceCto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 204, message = "No content found"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @GetMapping(value = "/place/favourite/{userId}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    List<PlaceCto> getAllFavouritePlaces(@PathVariable(value = "userId") Long userId);


    @ApiOperation(value = "Creates place",
            tags = {"place"},
            response = PlaceCto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PostMapping(value = "/place",
            consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PlaceCto> createPlace(@Validated @RequestBody PlaceTo placeTo);

    @ApiOperation(value = "Creates category",
            tags = {"category"},
            response = CategoryEto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PostMapping(value = "/category",
            consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryEto> createCategory(@Validated @RequestBody CategoryTo categoryTo);

    @ApiOperation(value = "Add favourite place",
            tags = {"place"},
            response = PlaceCto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PostMapping(value = "/place/{placeId}/favourite/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PlaceCto> addFavouritePlace(@PathVariable Long placeId, @PathVariable Long userId);

    @ApiOperation(value = "Remove favourite place",
            tags = {"place"},
            response = PlaceCto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @DeleteMapping(value = "/place/{placeId}/favourite/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PlaceCto> removeFavouritePlace(@PathVariable Long placeId, @PathVariable Long userId);


    @ApiOperation(value = "Updates place",
            tags = {"place"},
            response = PlaceCto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PutMapping(value = "/place/{id}",
            consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PlaceCto> updatePlace(@PathVariable(value = "id") Long id, @Validated @RequestBody  PlaceTo placeTo);

    @ApiOperation(value = "Updates category",
            tags = {"category"},
            response = CategoryEto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PutMapping(value = "/category/{id}",
            consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryEto> updateCategory(@PathVariable(value = "id") Long id, @Validated @RequestBody  CategoryTo categoryTo);

    @ApiOperation(value = "Deletes place",
            tags = {"place"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @DeleteMapping(value = "/place/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> deletePlace(@PathVariable(value = "id") Long id);

    @ApiOperation(value = "Deletes category",
            tags = {"category"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @DeleteMapping(value = "/category/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long id);

}
