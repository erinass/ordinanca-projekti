package com.example.pacient.mappers;

import com.example.pacient.dtos.AppointmentDto;
import com.example.pacient.dtos.ReportDto;
import com.example.pacient.models.Appointment;
import com.example.pacient.models.Reports;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment toEntity(AppointmentDto dto){
        Appointment appointment = new Appointment();
        appointment.setId(dto.getId());
        appointment.setPacient(dto.getPacient());
        appointment.setAppointmentType(dto.getAppointmentType());
        appointment.setActive(dto.isActive());
        appointment.setAppointmentBookingType(dto.getAppointmentBookingType());
        return appointment;
    }

    public AppointmentDto toDto(Appointment appointment){
        AppointmentDto dto = new AppointmentDto();
        dto.setId(appointment.getId());
        dto.setPacient(appointment.getPacient());
        dto.setAppointmentType(appointment.getAppointmentType());
        dto.setActive(appointment.isActive());
        dto.setAppointmentBookingType(appointment.getAppointmentBookingType());
        return dto;

    }
}
