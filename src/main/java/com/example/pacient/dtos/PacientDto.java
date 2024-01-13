package com.example.pacient.dtos;

import com.example.pacient.models.Reports;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacientDto {
    private long id;
    private String name;
    private int age;
    private String city;
    private String email;
    private List<Reports> reports = new ArrayList<>();


}
