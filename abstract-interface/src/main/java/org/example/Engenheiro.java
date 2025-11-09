package org.example;

public class Engenheiro extends Funcionario implements Funcao {
    private Double salario;

    public Engenheiro(String cpf, String nome, Double salario) {
        super(cpf, nome);
        this.salario = salario;
    }

    //interface
    @Override
    public void trabalhar() {
        System.out.println("vender seus produtos");
    }

    //abstract
    @Override
    public Double calcularSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Engenheiro{" +
                "salario=" + salario +
                "} " + super.toString();
    }
}
