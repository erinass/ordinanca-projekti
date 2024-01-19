package com.example.pacient.controllers;

import com.example.pacient.dtos.AppointmentDto;
import com.example.pacient.dtos.AppointmentStatusChangeDto;
import com.example.pacient.dtos.PacientDto;
import com.example.pacient.models.Appointment;
import com.example.pacient.models.Pacient;
import com.example.pacient.services.AppointmentService;
import com.example.pacient.services.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }


    @GetMapping
    public List<AppointmentDto> findAll(){
        return service.findAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDto findById(@PathVariable long id){

        return service.findAppointmentById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        service.deleteAppointmentById(id);
    }



    @PostMapping
    public void create(@RequestBody AppointmentDto appointmentDto){
        service.createAppointment(appointmentDto);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody AppointmentDto newAppointmentDto, @PathVariable long id){
        service.updateAppointment(newAppointmentDto,id);
    }
    @PatchMapping("/{id}")
    public void changeReportStatus(@PathVariable long id, @RequestBody AppointmentStatusChangeDto updatedAppointment) {
        service.changeStatus(id, updatedAppointment);
    }

}
