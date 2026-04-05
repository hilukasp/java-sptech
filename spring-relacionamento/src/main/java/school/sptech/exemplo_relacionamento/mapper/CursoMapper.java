package school.sptech.exemplo_relacionamento.mapper;

import school.sptech.exemplo_relacionamento.dto.curso.CursoRequestDto;
import school.sptech.exemplo_relacionamento.dto.curso.CursoResponseDto;
import school.sptech.exemplo_relacionamento.model.Curso;
import school.sptech.exemplo_relacionamento.model.Professor;

import java.util.List;

public class CursoMapper {

    public static Curso toEntity(CursoRequestDto dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setDataInicio(dto.getDataInicio());
        curso.setDataFim(dto.getDataFim());
        curso.setNota(dto.getNota());
        return curso;
    }

    public static CursoResponseDto toResponseDto(Curso curso) {
        Professor professorEntidade = curso.getProfessor();

        CursoResponseDto.ProfessorCursoDto professorDto =new CursoResponseDto.ProfessorCursoDto();
        professorDto.setId(professorEntidade.getId());
        professorDto.setNome(professorEntidade.getNome());

        CursoResponseDto dto = new CursoResponseDto();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setDataInicio(curso.getDataInicio());
        dto.setDataFim(curso.getDataFim());
        dto.setNota(curso.getNota());
        dto.setProfessor(professorDto);
        return dto;
    }

    public static List<CursoResponseDto> toResponseDtoList(List<Curso> cursos) {
        return cursos.stream()
                .map(CursoMapper::toResponseDto)
                .toList();
    }
}
