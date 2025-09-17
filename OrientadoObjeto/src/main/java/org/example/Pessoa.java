package org.example;
public class Pessoa {
    public String nome; // cada objeto tem seu próprio nome
    public static String nomeerrado;

    public void alterandoNome(String nomeparamentro){
        nome=nomeparamentro;
    }

    String retornandoVariavel(int valor){
        String valorconvertido=Integer.toString(valor);
        return valorconvertido;
    }
}
