package com.example.pacient.mappers;

import com.example.pacient.dtos.PacientDto;
import com.example.pacient.models.Pacient;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class PacientMapper {

    public Pacient toEntity(PacientDto pacientDto) {
        if (pacientDto == null) {
// Handle the case where pacientDto is null, throw an exception or return null, depending on your logic.
            throw new IllegalArgumentException("PacientDto cannot be null");
        }
        Pacient pacient = new Pacient();
        pacient.setName(pacientDto.getName());
        pacient.setEmail(pacientDto.getEmail());
        pacient.setCity(pacientDto.getCity());
        pacient.setAge(pacientDto.getAge());
        pacient.setId(pacientDto.getId());
        pacient.setReports(pacientDto.getReports());
        return pacient;
    }

    public PacientDto toDto(Pacient pacient) {
        PacientDto pacientDto = new PacientDto();
        pacientDto.setName(pacient.getName());
        pacientDto.setEmail(pacient.getEmail());
        pacientDto.setCity(pacient.getCity());
        pacientDto.setId(pacient.getId());
        pacientDto.setAge(pacient.getAge());
        pacientDto.setReports(pacient.getReports());
        return pacientDto;
    }
}