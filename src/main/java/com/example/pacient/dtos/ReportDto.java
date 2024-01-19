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
public class ReportDto {
    private Long id;
    private Pacient pacient;
    private long pacientId;
    private String anamnesis;
    private String therapy;
    private String disease;
    private String description;
}
