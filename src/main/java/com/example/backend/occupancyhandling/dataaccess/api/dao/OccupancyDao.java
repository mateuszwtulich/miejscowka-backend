package com.example.backend.occupancyhandling.dataaccess.api.dao;

import com.example.backend.occupancyhandling.dataaccess.api.entity.OccupancyEntity;
import com.example.backend.occupancyhandling.dataaccess.api.entity.OccupancyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OccupancyDao extends JpaRepository<OccupancyEntity, OccupancyId> {

    Optional<OccupancyEntity> findByIdPlaceId(Long placeId);
}
