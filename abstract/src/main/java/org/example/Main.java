package org.example;

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
//
//        engenheiro.calcularSalario();
//        vendedor.calcularSalario();
    }
}