package org.example;

public class Vendedor extends Funcionario{

    public Vendedor(String cpf, String nome) {
        super(cpf, nome);
    }

    @Override
    public Double calcularSalario() {
        return 0.0;
    }
}
