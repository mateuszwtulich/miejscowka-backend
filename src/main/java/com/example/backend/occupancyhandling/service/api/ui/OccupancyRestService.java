package com.example.backend.occupancyhandling.service.api.ui;

import com.example.backend.general.common.api.RestService;
import com.example.backend.occupancyhandling.logic.api.to.OccupancyTo;
import com.example.backend.placehandling.logic.api.to.PlaceCto;
import com.example.backend.placehandling.logic.api.to.PlaceTo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public interface OccupancyRestService extends RestService {

    @ApiOperation(value = "Updates occupancy",
            tags = {"occupancy"},
            response = OccupancyTo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 403, message = "You dont have permissions for this action!"),
            @ApiResponse(code = 404, message = "Entity not found"),
            @ApiResponse(code = 422, message = "Could not process entity"),
            @ApiResponse(code = 429, message = "Too many requests"),
    })
    @PutMapping(value = "/place/{placeId}/occupancy",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OccupancyTo> updateOccupancy(@PathVariable Long placeId, @RequestParam Integer numberOfPeople, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime time);

}
