package com.example.backend.occupancyhandling.service.impl;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.occupancyhandling.logic.api.to.OccupancyTo;
import com.example.backend.occupancyhandling.logic.impl.OccupancyHandlingImpl;
import com.example.backend.occupancyhandling.service.api.ui.OccupancyRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.inject.Inject;
import java.time.LocalDateTime;

@RestController
public class OccupancyRestServiceImpl implements OccupancyRestService {

    @Inject
    private OccupancyHandlingImpl occupancyHandling;

    @Override
    public ResponseEntity<OccupancyTo> updateOccupancy(Long placeId, Integer numberOfPeople, LocalDateTime time) {
        try {
            return ResponseEntity
                    .ok()
                    .body(occupancyHandling.updateOccupancy(placeId, numberOfPeople, time).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
