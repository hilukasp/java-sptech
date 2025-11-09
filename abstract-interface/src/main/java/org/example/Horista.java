package org.example;


public class Horista extends Funcionario implements Funcao{
    public Double valorHora;
    public Integer qtdHora;

    @Override
    public void trabalhar(){
        System.out.println("Horista trabalhado");
    }

    @Override
    public Double calcularSalario() {
        return qtdHora*valorHora;
    }

    public Horista(String cpf, String nome, Double valorHora, Integer qtdHora) {
        super(cpf, nome);
        this.valorHora = valorHora;
        this.qtdHora = qtdHora;
    }

    @Override
    public String toString() {
        return "Horista{" +
                "valorHora=" + valorHora +
                ", qtdHora=" + qtdHora +
                "} " + super.toString();
    }
}
