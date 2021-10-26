package com.example.backend.placehandling.dataaccess.api.dao;

import com.example.backend.placehandling.dataaccess.api.entity.PlaceImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceImageDao extends JpaRepository<PlaceImageEntity, Long> {
}
