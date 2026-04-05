package school.sptech.exemplo_relacionamento.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exemplo_relacionamento.dto.professor.ProfessorRequestDto;
import school.sptech.exemplo_relacionamento.dto.professor.ProfessorResponseDto;
import school.sptech.exemplo_relacionamento.mapper.ProfessorMapper;
import school.sptech.exemplo_relacionamento.model.Professor;
import school.sptech.exemplo_relacionamento.service.ProfessorService;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> criar(@RequestBody @Valid ProfessorRequestDto dto) {
        Professor professor = ProfessorMapper.toEntity(dto);
        Professor criado = professorService.criar(professor);
        return ResponseEntity.status(201).body(ProfessorMapper.toResponseDto(criado));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> listar() {
        List<Professor> professores = professorService.listar();
        return ResponseEntity.ok(ProfessorMapper.toResponseDtoList(professores));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> buscarPorId(@PathVariable Integer id) {
        Professor professor = professorService.buscarPorId(id);
        return ResponseEntity.ok(ProfessorMapper.toResponseDto(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> atualizar(@PathVariable Integer id, @RequestBody @Valid ProfessorRequestDto dto) {
        Professor professor = ProfessorMapper.toEntity(dto);
        Professor atualizado = professorService.atualizar(id, professor);
        return ResponseEntity.ok(ProfessorMapper.toResponseDto(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        professorService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
