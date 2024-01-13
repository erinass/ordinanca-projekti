package com.example.pacient.services;

import com.example.pacient.dtos.PacientDto;
import com.example.pacient.dtos.ReportDto;
import com.example.pacient.mappers.PacientMapper;
import com.example.pacient.mappers.ReportMapper;
import com.example.pacient.models.Pacient;
import com.example.pacient.models.Reports;
import com.example.pacient.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    private final PacientService pacientService;

    private final PacientMapper pacientMapper;

    @Autowired
    public ReportService(ReportRepository reportRepository, ReportMapper reportMapper, PacientService pacientService, PacientMapper pacientMapper) {
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
        this.pacientService = pacientService;
        this.pacientMapper = pacientMapper;
    }

    public List<ReportDto> findAllReports() {
        return reportRepository.findAll().stream().map(reportMapper::toDto).toList();
    }

    public ReportDto findReportById(long id) {
        var entity = reportRepository.findById(id);
        if (entity.isEmpty())
            throw new RuntimeException("Report case not found");
        var dto = reportMapper.toDto(entity.get());
        return dto;
    }

    public void deleteReportById(long id) {
        reportRepository.deleteById(id);
    }

    public void createReport(ReportDto reportDto) {
        PacientDto pacientDto = pacientService.findById(reportDto.getPacientId());
        Pacient pacient = pacientMapper.toEntity(pacientDto);
        reportDto.setPacient(pacient);
        reportRepository.save(reportMapper.toEntity(reportDto));
    }

    public void updateReport(ReportDto newReportDto, long id) {
        PacientDto pacientDto = pacientService.findById(newReportDto.getPacientId());
        Pacient pacient = pacientMapper.toEntity(pacientDto);
        newReportDto.setPacient(pacient);
        var optionalEntity = reportRepository.findById(id);

        if (optionalEntity.isEmpty())
            throw new RuntimeException("Order not found");

        var entity = optionalEntity.get();
        entity.setPacient(newReportDto.getPacient());
        entity.setDescription(newReportDto.getDescription());
        entity.setDisease(newReportDto.getDisease());
        entity.setAnamnesis(newReportDto.getAnamnesis());
        entity.setTherapy(newReportDto.getTherapy());

        reportRepository.save(entity);
    }
}
