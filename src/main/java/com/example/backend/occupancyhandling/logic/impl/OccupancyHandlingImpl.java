package com.example.backend.occupancyhandling.logic.impl;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.occupancyhandling.logic.api.OccupancyHandling;
import com.example.backend.occupancyhandling.logic.api.to.OccupancyTo;
import com.example.backend.occupancyhandling.logic.api.usecase.UcOccupancy;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class OccupancyHandlingImpl implements OccupancyHandling {

    @Inject
    private UcOccupancy ucOccupancy;

    @Override
    public Optional<OccupancyTo> updateOccupancy(Long placeId, Integer numberOfPeople, LocalDateTime time) throws EntityDoesNotExistException {
        return ucOccupancy.updateOccupancy(placeId, numberOfPeople, time);
    }
}
