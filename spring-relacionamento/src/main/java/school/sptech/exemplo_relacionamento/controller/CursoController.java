package school.sptech.exemplo_relacionamento.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exemplo_relacionamento.dto.curso.CursoRequestDto;
import school.sptech.exemplo_relacionamento.dto.curso.CursoResponseDto;
import school.sptech.exemplo_relacionamento.mapper.CursoMapper;
import school.sptech.exemplo_relacionamento.model.Curso;
import school.sptech.exemplo_relacionamento.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoResponseDto> criar(@RequestBody @Valid CursoRequestDto dto) {
        Curso curso = CursoMapper.toEntity(dto);
        Curso criado = cursoService.criar(curso, dto.getProfessor_id());
        return ResponseEntity.status(201).body(CursoMapper.toResponseDto(criado));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> listar() {
        List<Curso> cursos = cursoService.listar();
        return ResponseEntity.ok(CursoMapper.toResponseDtoList(cursos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> buscarPorId(@PathVariable Integer id) {
        Curso curso = cursoService.buscarPorId(id);
        return ResponseEntity.ok(CursoMapper.toResponseDto(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> atualizar(@PathVariable Integer id, @RequestBody @Valid CursoRequestDto dto,Integer professorId) {
        Curso curso = CursoMapper.toEntity(dto);
        Curso atualizado = cursoService.atualizar(id, curso,professorId);
        return ResponseEntity.ok(CursoMapper.toResponseDto(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cursoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/media")
    public ResponseEntity<Double> getMedia(){
        //sobrecarrega o banco
//        List<Curso> cursos=cursoService.listar();
//        Double resultado=0.0;
//        for (Curso curso : cursos) {
//            resultado =+ curso.getNota();
//        }
//        resultado=resultado/(cursos.size());

        Double resultado=cursoService.getMedia();
        return ResponseEntity.ok(resultado);
    }
}
