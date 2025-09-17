package org.example;

import java.util.ArrayList;
import java.util.List;

public class listas {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();//vetor sem limite
        lista.add("mickey");
        lista.add("minnie");
        lista.add("pateta");

        //for each. tipo apelido : parametro
        for (String nome : lista){//for enhanced
            System.out.println(nome);
        }
        //retorna o tamanho da lista
        System.out.println(lista.size());

        lista.add(0,"rato");//adiciona rato no 0 index
        lista.remove(1); //remove o elemento de index 1

        //devolve true se conter e false se não conter
        System.out.println(lista.contains("rato"));

        for (String nome : lista){
            System.out.println(nome);
        }

        //Obtendo o indice de um valor da lista
        System.out.println(lista.indexOf("minnie"));


        //obtem o elemento especifico pelo indice
        System.out.println(lista.get(0));

        lista.clear();//apaga todos os registros da lista

    }
}
