package com.example.pacient.repositories;

import com.example.pacient.dtos.PacientDto;
import com.example.pacient.models.Pacient;
import com.example.pacient.models.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Reports, Long> {

}
