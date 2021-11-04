package com.example.backend.placehandling.dataaccess.api.dao;

import com.example.backend.placehandling.dataaccess.api.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findById(Long id);
}
