package com.example.pacient.controllers;

import com.example.pacient.dtos.PacientDto;
import com.example.pacient.dtos.ReportDto;
import com.example.pacient.models.Pacient;
import com.example.pacient.services.PacientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacient")
@CrossOrigin(origins = "*")
public class PacientController {


    private final PacientService service;

    public PacientController(PacientService service) {
        this.service = service;
    }


    @GetMapping
    public List<PacientDto> findAll(){
       return service.findAll();
    }

    @GetMapping("/{id}")
    public PacientDto findById(@PathVariable long id){

        return service.findById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        service.deleteById(id);
    }



    @PostMapping
    public void create(@RequestBody PacientDto pacient){
        service.create(pacient);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody PacientDto newPacientDto, @PathVariable long id){
        service.update(newPacientDto,id);
    }


}
