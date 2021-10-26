package com.example.backend.placehandling.dataaccess.api.dao;

import com.example.backend.placehandling.dataaccess.api.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceDao extends JpaRepository<PlaceEntity, Long> {

    List<PlaceEntity> findAllByCategory_Id(Long categoryId);

    Optional<PlaceEntity> findByName(String name);

}
