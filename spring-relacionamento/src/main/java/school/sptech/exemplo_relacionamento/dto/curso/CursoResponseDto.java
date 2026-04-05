package school.sptech.exemplo_relacionamento.dto.curso;

import java.time.LocalDate;

public class CursoResponseDto {

    private Integer id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double nota;
    private ProfessorCursoDto professor;

    //Inner classes, Nested classes
    public static class ProfessorCursoDto{
        private Integer id;
        private String nome;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
    //get e setter
    public ProfessorCursoDto getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorCursoDto professor) {
        this.professor = professor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

}
