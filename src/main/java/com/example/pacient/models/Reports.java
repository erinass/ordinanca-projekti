package com.example.pacient.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pacient_name")

    private Pacient pacient;
    private String anamnesis;
    private String disease;
    private String therapy;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
}
