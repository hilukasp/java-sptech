package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String nome="a";
        Integer idade=22;
        Double altura=70.0;

        String textoFormatado= String.format("Olá %s, você tem %d anos, e mede %.2f m",
                nome,idade,altura);
        System.out.println(textoFormatado);

        Scanner e = new Scanner(System.in);
        String textodigitado = e.nextLine(); //lê o texto até o enter
        System.out.println(textodigitado);

        String textodigitado2 = e.next();//lê o texto até o espaço
        System.out.println(textodigitado2);

        Integer numero = e.nextInt();//lê o texto até o espaço
        System.out.println(numero);
    }
}