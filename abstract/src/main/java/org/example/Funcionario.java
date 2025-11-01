package org.example;

public abstract class Funcionario {
    //não permite que você crie um objeto dela
    //não pode ser instânciada
    private String cpf;
    private String nome;

    public Funcionario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public abstract Double calcularSalario();

    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", salario="+String.format("%.2f",calcularSalario())+'\''+
                '}';
    }
}
