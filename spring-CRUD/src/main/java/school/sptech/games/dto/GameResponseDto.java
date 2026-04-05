package school.sptech.games.dto;

import java.time.LocalDate;

public class GameResponseDto {

    private Long id;
    private String nome;
    private String empresa;
    private LocalDate dataPublicacao;
    private Double nota;
    private boolean crossplataform;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
