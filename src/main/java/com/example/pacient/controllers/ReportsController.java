package com.example.pacient.controllers;

import com.example.pacient.dtos.AppointmentDto;
import com.example.pacient.dtos.ReportDto;
import com.example.pacient.models.Appointment;
import com.example.pacient.models.Reports;
import com.example.pacient.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportsController {
    private final ReportService service;

    public ReportsController(ReportService service) {
        this.service = service;
    }


    @GetMapping
    public List<ReportDto> findAll(){
        return service.findAllReports();
    }

    @GetMapping("/{id}")
    public ReportDto findById(@PathVariable long id){

        return service.findReportById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        service.deleteReportById(id);
    }



    @PostMapping
    public void create(@RequestBody ReportDto reportDto){
        service.createReport(reportDto);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody ReportDto newReportDto, @PathVariable long id){
        service.updateReport(newReportDto,id);
    }
}
