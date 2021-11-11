package com.example.backend.occupancyhandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.occupancyhandling.dataaccess.api.dao.OccupancyDao;
import com.example.backend.occupancyhandling.dataaccess.api.entity.OccupancyEntity;
import com.example.backend.occupancyhandling.dataaccess.api.entity.OccupancyId;
import com.example.backend.occupancyhandling.logic.api.mapper.OccupancyMapper;
import com.example.backend.occupancyhandling.logic.api.to.OccupancyTo;
import com.example.backend.occupancyhandling.logic.api.usecase.UcOccupancy;
import com.example.backend.placehandling.dataaccess.api.dao.PlaceDao;
import com.example.backend.placehandling.dataaccess.api.entity.PlaceEntity;
import com.example.backend.taskhandling.logic.impl.usecase.UcManageTaskImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Validated
@Named
public class UcOccupancyImpl implements UcOccupancy {
    private static final Logger LOG = LoggerFactory.getLogger(UcManageTaskImpl.class);
    private static final String UPDATE_OCCUPANCY_LOG = "Update Occupancy with placeId {} in database.";

    @Inject
    private OccupancyDao occupancyDao;

    @Inject
    private PlaceDao placeDao;

    @Override
    public Optional<OccupancyTo> updateOccupancy(Long placeId, Integer numberOfPeople, LocalDateTime time) throws EntityDoesNotExistException {

        LOG.debug(UPDATE_OCCUPANCY_LOG, placeId);

        PlaceEntity placeEntity = placeDao.findById(placeId).orElseThrow(() -> new EntityDoesNotExistException("Place with id " + placeId + "does not exist"));

        Optional<OccupancyEntity> occupancyEntityOpt = occupancyDao.findByIdPlaceId(placeId);

        OccupancyEntity occupancyEntity;

        if(occupancyEntityOpt.isPresent()){
            occupancyEntity = occupancyEntityOpt.get();
            occupancyEntity.getId().setTimeId(time);
            occupancyEntity.setNumber_of_people(numberOfPeople);
            occupancyEntity.setPercentage_occupancy(calculatePercentageOccupancy(numberOfPeople, placeEntity.getCapacity()));
        }else {
            OccupancyId occupancyId = new OccupancyId();
            occupancyId.setPlaceId(placeId);
            occupancyId.setTimeId(time);

            occupancyEntity = new OccupancyEntity();
            occupancyEntity.setId(occupancyId);
            occupancyEntity.setPlace(placeEntity);
            occupancyEntity.setNumber_of_people(numberOfPeople);
            occupancyEntity.setPercentage_occupancy(calculatePercentageOccupancy(numberOfPeople, placeEntity.getCapacity()));
            occupancyDao.save(occupancyEntity);
        }

        return Optional.of(toOccupancyTo(occupancyEntity));
    }

    private int calculatePercentageOccupancy(Integer numberOfPeople, Integer capacity){
        return (int) ((numberOfPeople * 100) / (capacity));
    }

    private OccupancyTo toOccupancyTo(OccupancyEntity occupancyEntity){
        OccupancyTo occupancyTo = new OccupancyTo();

        occupancyTo.setNumber_of_people(occupancyEntity.getNumber_of_people());
        occupancyTo.setPercentage_occupancy(occupancyEntity.getPercentage_occupancy());
        return  occupancyTo;
    }

}
