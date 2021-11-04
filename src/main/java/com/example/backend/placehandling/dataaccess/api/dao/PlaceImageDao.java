package com.example.backend.placehandling.dataaccess.api.dao;

import com.example.backend.placehandling.dataaccess.api.entity.PlaceImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceImageDao extends JpaRepository<PlaceImageEntity, Long> {
    List<PlaceImageEntity> findAllByPlace_Id(Long placeId);
}
