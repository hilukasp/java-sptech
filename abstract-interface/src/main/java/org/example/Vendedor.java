package org.example;

public class Vendedor extends Funcionario implements Funcao {
    public Double vendas;
    public Double taxa;

    public Vendedor(String cpf, String nome, Double vendas, Double taxa) {
        super(cpf, nome);
        this.vendas = vendas;
        this.taxa = taxa;
    }

    //interface
    @Override
    public void trabalhar() {
        System.out.println("realizar medição de área");
    }
    //abstract
    @Override
    public Double calcularSalario() {
        return vendas*taxa;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "vendas=" + vendas +
                ", taxa=" + taxa +
                "} " + super.toString();
    }
}
