package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vendedor vendedor=new Vendedor("321","rodrigo",300.0);
        Engenheiro engenheiro=new Engenheiro("123","mathis",2000.0);
        System.out.println(engenheiro);
        System.out.println(vendedor);
//
//        engenheiro.calcularSalario();
//        vendedor.calcularSalario();
    }
}