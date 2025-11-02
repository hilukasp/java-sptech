package org.example;

public abstract class Funcionario {
    //não permite que você crie um objeto dela
    //não pode ser instânciada

    //herança classe pai
    /*exibir ele sozinho não faz sentido pois dentro desses funcionarios
     tem diferentes tipos de trabalhador
    */

    /*classe abstract serve para padronizar e organizar o que cada elemento tem e faz*/

    private String cpf;
    private String nome;

    public Funcionario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    //força cada subclasse ter esse métod
    //cada funcionario tem um salario diferente
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
