package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    //primeiro você implementa os testes e depolis você coda
    //TDD você define a resposta que você gostaria de receber e não a resposta que poderia ser recebida.
    //define a resposta que você gostaria de receber e depois volta para o codigo original para arrumae
    @Test
    @DisplayName("tituloDoteste")
    void deveSomarCorretamente() {
        //AAA (triple A)
        //arrange (preparar os dados)
        Calculadora calculadora = new Calculadora();
        //act (Atuar, chamar o metodo)
        Double resultado= calculadora.somar(2.0,3.0);
        //assert (setar a resposta)
        Assertions.assertEquals(5.0, resultado);
    }

    @Test
    @DisplayName("valor nulo")
    void ResultadoNulo(){

        Calculadora calculadora = new Calculadora();

        //Double resultado= calculadora.somar(2.0,null);
        //da nulo

        Assertions.assertThrows(IllegalArgumentException.class, ()->calculadora.somar(2.0,null));
    }

    @Test
    void Zero(){

        Calculadora calculadora = new Calculadora();
        Double resultado= calculadora.dividir(2.0,0.0);
        Assertions.assertEquals(0.0, resultado);
    }

}