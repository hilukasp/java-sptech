package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa();

        p1.nome = "Maria";
        p2.nome = "João";

        p1.nomeerrado = "Maria";
        p2.nomeerrado = "João";

        System.out.println("sem o static");
        System.out.println("Pessoa 1: " + p1.nome);
        System.out.println("Pessoa 2: " + p2.nome);
        System.out.println("");
        System.out.println("com o static");
        System.out.println("Pessoa 1: " + p1.nomeerrado);
        System.out.println("Pessoa 2: " + p2.nomeerrado);

        System.out.println("não use static em POO");
        System.out.println();
        p1.alterandoNome("Pedro");
        System.out.println(p1.nome);

        System.out.println(p1.retornandoVariavel(3));
    }
}