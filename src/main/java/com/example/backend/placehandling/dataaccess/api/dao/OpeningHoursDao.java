package com.example.backend.placehandling.dataaccess.api.dao;

import com.example.backend.placehandling.dataaccess.api.entity.OpeningHoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningHoursDao extends JpaRepository<OpeningHoursEntity, Long> {
}
