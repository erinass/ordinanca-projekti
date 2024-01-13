package com.example.pacient.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        private int age;
        @Column(nullable = true)
        private String city;
        private String email;
        private LocalDateTime createdAt = LocalDateTime.now();
    @JsonManagedReference
    @OneToMany(mappedBy = "pacient", cascade = CascadeType.ALL)
        private List<Reports> reports = new ArrayList<>();


}
