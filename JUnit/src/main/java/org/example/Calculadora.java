package org.example;

import java.util.stream.Stream;

public class Calculadora {
    //primeiro você implementa os testes e depolis você coda
    //TDD você define a resposta que você gostaria de receber e não a resposta que poderia ser recebida.
    //define a resposta que você gostaria de receber e depois volta para o codigo original para arrumae

    public Double somar(Double num1,Double num2){
        //segundo o TDD primeiro criamos o metodo sem logica
        //alt+insert

        if (num1==null||num2==null){
            throw new IllegalArgumentException("Numero não pode ser nulo");
        }
        return num1+num2;
    }


    // Metodo que você quer testar
    Double dividir(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Numero não pode ser nulo");
        }
        if (num2 == 0) {
            throw new ArithmeticException("Divisão por zero");
        }
        return num1 / num2;
    }
}


