package com.example.backend.placehandling.dataaccess.api.dao;

import com.example.backend.placehandling.dataaccess.api.entity.OpeningHoursEntity;
import com.example.backend.placehandling.dataaccess.api.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpeningHoursDao extends JpaRepository<OpeningHoursEntity, Long> {

    Optional<OpeningHoursEntity> findById(Long id);

}
