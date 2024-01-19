package com.example.pacient.services;

import com.example.pacient.dtos.PacientDto;
import com.example.pacient.dtos.ReportDto;
import com.example.pacient.mappers.PacientMapper;
import com.example.pacient.mappers.ReportMapper;
import com.example.pacient.models.Pacient;
import com.example.pacient.repositories.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PacientServiceImpl implements PacientService{
    private final PacientRepository repository;
    private final PacientMapper pacientMapper;

    @Autowired
    public PacientServiceImpl(PacientRepository repository, PacientMapper pacientMapper) {
        this.repository = repository;
        this.pacientMapper = pacientMapper;
    }

    @Override
    public List<PacientDto> findAll() {
        return repository.findAll().stream().map(pacientMapper::toDto).toList();
    }
    @Override
    public PacientDto findById(long id) {
        var entity = repository.findById(id);
        if (entity.isEmpty())
            throw new RuntimeException("Report case not found");
        var dto = pacientMapper.toDto(entity.get());
        return dto;
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
    @Override
    public void create(PacientDto pacientDto) {
        var entity = pacientMapper.toEntity(pacientDto);
//        entity.getReports().forEach(reports -> reports.setPacient(entity));
//        if (entity.getReports() !=null){
//            Pacient pacient = entity.getReports();
//        }
        repository.save(entity);
    }

    @Override
    public void update(PacientDto newPacientDto, long id) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty())
            throw new RuntimeException("Order not found");
        var entity = optionalEntity.get();
        entity.setName(newPacientDto.getName());
        entity.setAge(newPacientDto.getAge());
        entity.setEmail(newPacientDto.getEmail());
        entity.setCity(newPacientDto.getCity());
        entity.setReports(newPacientDto.getReports());
        repository.save(entity);
    }
    @Override
    public PacientDto findByPacientName(String pacientName) {
        Optional<Pacient> obj = repository.findAll().stream().filter(item -> item.getName().equals(pacientName)).findFirst();
        PacientDto pacient = pacientMapper.toDto(obj.get());
        if (pacient == null) {
            throw new RuntimeException("Pacient not found");
        }
        return pacient;
    }
}