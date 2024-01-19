package com.example.pacient.dtos;

import com.example.pacient.models.Pacient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDto {
    private Long id;
    private Pacient pacient;
    private long pacientId;
    private String appointmentType;
    private String appointmentBookingType;
    private boolean isActive;
}
