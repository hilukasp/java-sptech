package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcionario  implements Funcao{
    //não permite que você crie um objeto dela
    //não pode ser instânciada

    /*classe abstract serve para padronizar e organizar o que cada elemento tem e faz*/

    /*você tem funções que tem a mesma finalidade mas meios diferentes para calcular*/

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
