package school.sptech.jpa;

public class HeroiDTO {
    private String nome;
    private Integer forca;
    private String arma;
    private Boolean temCapa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public Boolean getTemCapa() {
        return temCapa;
    }

    public void setTemCapa(Boolean temCapa) {
        this.temCapa = temCapa;
    }

    public HeroiDTO() {
    }

    public HeroiDTO(String nome, Integer forca, String arma, Boolean temCapa) {
        this.nome = nome;
        this.forca = forca;
        this.arma = arma;
        this.temCapa = temCapa;
    }
}
