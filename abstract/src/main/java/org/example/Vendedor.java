package org.example;

public class Vendedor extends Funcionario{
    public double salario;

    public Vendedor(String cpf, String nome, double salario) {
        super(cpf, nome);
        this.salario = salario;
    }

    @Override
    public Double calcularSalario() {
        System.out.println("salario");
        return salario;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "salario=" + salario +
                "} "+super.toString();
    }
}
