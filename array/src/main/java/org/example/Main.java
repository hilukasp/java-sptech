package org.example;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Integer numero;


    //criando um vetor
    public static Integer[] vetor = new Integer[5];
    public static String vetor2[] = new String[3];

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            vetor[i]=i*10;
        }

        for (int i=0;i<(vetor.length);i++){
            System.out.println(vetor[i]);
        }

        Scanner e=new Scanner(System.in);

        for (int i=0;i<(vetor2.length);i++){
            vetor2[i]=e.next();
        }
        //exibe o endereço de memória
        System.out.println(vetor2);

        //exibe o array
        System.out.println(Arrays.toString(vetor2));
    }
}

