package org.example;

public abstract class Funcionario {
    //não permite que você crie um objeto dela
    //não pode ser instânciada

    //herança classe pai
    /*exibir ele sozinho não faz sentido pois dentro desses funcionarios
     tem diferentes tipos de trabalhador
    */

    /*classe abstract serve para padronizar e organizar o que cada elemento tem e faz*/

    /*você tem funções que tem a mesma finalidade mas meios diferentes para calcular*/

    private String cpf;
    private String nome;

    public Funcionario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    //força cada subclasse ter esse métod
    //cada funcionario calcula o salario de forma diferente
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
