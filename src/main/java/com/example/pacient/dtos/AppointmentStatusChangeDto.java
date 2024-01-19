package com.example.pacient.dtos;

import lombok.Data;

@Data
public class AppointmentStatusChangeDto {
    private long id;
    private boolean isActive;
}

