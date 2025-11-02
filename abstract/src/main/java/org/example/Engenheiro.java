package org.example;

public class Engenheiro extends Funcionario{
    private Double salario;

    public Engenheiro(String cpf, String nome, Double salario) {
        super(cpf, nome);
        this.salario = salario;
    }

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
