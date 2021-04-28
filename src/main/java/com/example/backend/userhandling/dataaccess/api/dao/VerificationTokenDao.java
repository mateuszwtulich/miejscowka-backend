package com.example.backend.userhandling.dataaccess.api.dao;

import com.example.backend.userhandling.dataaccess.api.entity.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenDao extends JpaRepository<VerificationTokenEntity, Long> {

  Optional<VerificationTokenEntity> findByToken(String token);
}
