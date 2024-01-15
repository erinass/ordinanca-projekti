package com.example.pacient.repositories;

import com.example.pacient.dtos.PacientDto;
import com.example.pacient.models.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  PacientRepository extends JpaRepository<Pacient, Long> {
    @Query("SELECT p FROM Pacient p WHERE p.name = :pacientName")
    PacientDto findByPacientName(@Param("pacientName") String pacientName);
}
