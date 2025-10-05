package org.example;

public class Time {

    //ATRIBUTOS
    //Lembrete: O nome dos atributos devem ser os mesmos da coluna do Banco
    private Integer id;
    private String nome;
    private Integer qtdJogadores;


    //CONTRUTORES
    public Time(Integer id, String nome, Integer qtdJogadores) {
        this.id = id;
        this.nome = nome;
        this.qtdJogadores = qtdJogadores;
    }

    public Time() {
    }


    // GETTERS E SETTERS
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

    public Integer getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(Integer qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", qtdJogadores=" + qtdJogadores +
                '}';
    }
}
