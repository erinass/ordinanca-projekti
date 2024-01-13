package com.example.pacient.services;

import com.example.pacient.dtos.AppointmentDto;
import com.example.pacient.dtos.PacientDto;
import com.example.pacient.mappers.AppointmentMapper;
import com.example.pacient.mappers.PacientMapper;
import com.example.pacient.models.Pacient;
import com.example.pacient.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    private final PacientMapper pacientMapper;

    private final PacientService pacientService;
    @Autowired
    public AppointmentService(AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository, PacientMapper pacientMapper, PacientService pacientService) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
        this.pacientMapper = pacientMapper;
        this.pacientService = pacientService;
    }

    public List<AppointmentDto> findAllAppointments() {
        return appointmentRepository.findAll().stream().map(appointmentMapper::toDto).toList();
    }

   public AppointmentDto findAppointmentById(long id) {
        var entity = appointmentRepository.findById(id);
        if (entity.isEmpty())
            throw new RuntimeException("Report case not found");
        var dto = appointmentMapper.toDto(entity.get());
        return dto;
    }

   public void deleteAppointmentById(long id) {
        appointmentRepository.deleteById(id);
    }

   public void createAppointment(AppointmentDto appointmentDto) {
       PacientDto pacientDto = pacientService.findById(appointmentDto.getPacientId());
       Pacient pacient = pacientMapper.toEntity(pacientDto);
       appointmentDto.setPacient(pacient);
        appointmentRepository.save(appointmentMapper.toEntity(appointmentDto));
    }

   public void updateAppointment(AppointmentDto newAppointmentDto, long id) {
       PacientDto pacientDto = pacientService.findById(newAppointmentDto.getPacientId());
       Pacient pacient = pacientMapper.toEntity(pacientDto);
       newAppointmentDto.setPacient(pacient);
        var optionalEntity = appointmentRepository.findById(id);
        if (optionalEntity.isEmpty())
            throw new RuntimeException("Order not found");

        var entity = optionalEntity.get();
        entity.setPacient(newAppointmentDto.getPacient());
        entity.setAppointmentType(newAppointmentDto.getAppointmentType());
        entity.setActive(newAppointmentDto.isActive());
        entity.setAppointmentBookingType(newAppointmentDto.getAppointmentBookingType());

        appointmentRepository.save(entity);
    }
}
