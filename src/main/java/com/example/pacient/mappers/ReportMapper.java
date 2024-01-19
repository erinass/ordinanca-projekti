package com.example.pacient.mappers;

import com.example.pacient.dtos.PacientDto;
import com.example.pacient.dtos.ReportDto;
import com.example.pacient.models.Pacient;
import com.example.pacient.models.Reports;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {
    public Reports toEntity(ReportDto dto){
        Reports reports = new Reports();
        reports.setId(dto.getId());
        reports.setPacient(dto.getPacient());
        reports.setDescription(dto.getDescription());
        reports.setDisease(dto.getDisease());
        reports.setTherapy(dto.getTherapy());
        reports.setAnamnesis(dto.getAnamnesis());
        return reports;
    }

    public ReportDto toDto(Reports reports){
        ReportDto reportDto = new ReportDto();
        reportDto.setId(reports.getId());
        reportDto.setPacient(reports.getPacient());
        reportDto.setPacientId(reports.getPacient().getId());
        reportDto.setDescription(reports.getDescription());
        reportDto.setTherapy(reports.getTherapy());
        reportDto.setDisease(reports.getDisease());
        reportDto.setAnamnesis(reports.getAnamnesis());
        return reportDto;

    }

}
