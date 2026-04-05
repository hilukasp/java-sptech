package school.sptech.exemplo_relacionamento.mapper;

import school.sptech.exemplo_relacionamento.dto.professor.ProfessorRequestDto;
import school.sptech.exemplo_relacionamento.dto.professor.ProfessorResponseDto;
import school.sptech.exemplo_relacionamento.model.Curso;
import school.sptech.exemplo_relacionamento.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorMapper {

    public static Professor toEntity(ProfessorRequestDto dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setPremium(dto.getPremium());
        return professor;
    }

    //resposta com o relacionamento
    public static ProfessorResponseDto toResponseDto(Professor professor) {
        List<ProfessorResponseDto.CursoProfessorDto> cursosEntidade=new ArrayList<>();
        for (Curso curso : professor.getCursos()) {
            ProfessorResponseDto.CursoProfessorDto cursoDto = new ProfessorResponseDto.CursoProfessorDto();
            cursoDto.setId(curso.getId());
            cursoDto.setNome(curso.getNome());
            cursosEntidade.add(cursoDto);
        }

        ProfessorResponseDto dto = new ProfessorResponseDto();

        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setCadastradoEm(professor.getCadastradoEm());
        dto.setPremium(professor.getPremium());
        dto.setCursos(cursosEntidade);

        return dto;
    }

    public static List<ProfessorResponseDto> toResponseDtoList(List<Professor> professores) {
        return professores.stream()
                .map(ProfessorMapper::toResponseDto)
                .toList();
    }
}
