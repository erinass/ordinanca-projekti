package com.example.pacient.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;
    private String appointmentType;
    private  String appointmentBookingType;
    private boolean isActive;
    private LocalDateTime createdAt = LocalDateTime.now();
}
