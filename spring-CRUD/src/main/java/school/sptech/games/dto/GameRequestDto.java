package school.sptech.games.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class GameRequestDto {

    @NotBlank
    @Schema(example = "nome do atributo ", description = "descricao") //swagger
    private String nome;

    @NotBlank
    private String empresa;

    @NotNull
    private LocalDate dataPublicacao;

    @Min(0)
    @Max(5)
    private Double nota;

    private boolean crossplataform;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public boolean isCrossplataform() {
        return crossplataform;
    }

    public void setCrossplataform(boolean crossplataform) {
        this.crossplataform = crossplataform;
    }
}
