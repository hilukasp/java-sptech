package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vendedor vendedor=new Vendedor("321","rodrigo",500.0,2.0);
        Engenheiro engenheiro=new Engenheiro("123","mathis",2000.0);
        Horista horista=new Horista("222223","lopes",200.0,6);
        System.out.println(vendedor);
        System.out.println(engenheiro);
        System.out.println(horista);

        //adiciona a lista
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(vendedor);
        funcionarios.add(engenheiro);
        funcionarios.add(horista);

        //soma salarios dos funcionarios
        Double total=0.0;
        for (Funcionario funcionario : funcionarios) {
            total+=funcionario.calcularSalario();
        }
        System.out.println("total de salario: "+total);

        //interface
        //atributos contidos na interface é statico e imutável
        /*classe abstract e interface serve para padronizar e organizar o que cada elemento faz*/
        //a diferença é que a interface você pode implementar quantas vezes você quiser, a abstract é apenas uma vez
        //cada funcionário trabalha de maneira diferente
        System.out.println();
        for (Funcionario funcionario : funcionarios) {
            funcionario.trabalhar();
        }

        //polimorfismo, classe diferentes ter o mesmo metodo
        vendedor.trabalhar();
        engenheiro.trabalhar();
        horista.trabalhar();
    }
}