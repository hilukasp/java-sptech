package school.sptech.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity//representa uma tabela no banco de dados
//@Table(name="heroi")

public class Heroi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto incremento
    //@JsonIgnore //vai ignorar o campo json na hora de converter ele
    private Integer id;

    @Column(name="nome_heroi")//renomeia um atributo no sql
    private String nome;
    private String arma;
    private Integer forca;
    private Boolean temCapa;

    public Heroi(){

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

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Boolean getTemCapa() {
        return temCapa;
    }

    public void setTemCapa(Boolean temCapa) {
        this.temCapa = temCapa;
    }

    public Heroi(Integer id, String nome, String arma, Integer forca, Boolean temCapa) {
        this.id = id;
        this.nome = nome;
        this.arma = arma;
        this.forca = forca;
        this.temCapa = temCapa;
    }
}
