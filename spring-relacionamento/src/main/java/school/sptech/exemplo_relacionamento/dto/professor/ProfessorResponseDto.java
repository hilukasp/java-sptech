package school.sptech.exemplo_relacionamento.dto.professor;

import java.time.LocalDateTime;
import java.util.List;

public class ProfessorResponseDto {

    private Integer id;
    private String nome;
    private LocalDateTime cadastradoEm;
    private Boolean premium;
    private List<CursoProfessorDto> cursos;

    public static class CursoProfessorDto{
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

    public LocalDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public void setCadastradoEm(LocalDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public List<CursoProfessorDto> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoProfessorDto> cursos) {
        this.cursos = cursos;
    }
}
