package com.example.pacient.repositories;

import com.example.pacient.models.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PacientRepository extends JpaRepository<Pacient, Long> {
}
