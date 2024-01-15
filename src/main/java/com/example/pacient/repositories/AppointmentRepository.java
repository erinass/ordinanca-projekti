package com.example.pacient.repositories;

import com.example.pacient.dtos.PacientDto;
import com.example.pacient.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT a FROM Appointment a WHERE a.pacient.name = :pacientName")
    PacientDto findByPacientName(@Param("pacientName") String pacientName);
}
