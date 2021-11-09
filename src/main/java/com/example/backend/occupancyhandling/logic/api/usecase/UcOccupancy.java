package com.example.backend.occupancyhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.occupancyhandling.logic.api.to.OccupancyTo;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UcOccupancy {

    Optional<OccupancyTo> updateOccupancy(Long placeId, Integer numberOfPeople, LocalDateTime time) throws EntityDoesNotExistException;

}
