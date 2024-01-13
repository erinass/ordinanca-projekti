package com.example.pacient.services;

import com.example.pacient.dtos.PacientDto;
import com.example.pacient.dtos.ReportDto;
import com.example.pacient.models.Pacient;

import java.util.List;
import java.util.Optional;

public interface PacientService {


    List<PacientDto> findAll();
    PacientDto findById(long id);

    void deleteById(long id);

    void create(PacientDto pacientDto);

    void update(PacientDto newPacientDto, long id);
}
