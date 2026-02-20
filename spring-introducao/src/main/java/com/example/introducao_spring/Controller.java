package com.example.introducao_spring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping(/prefixo) adiciona o prefixo em todas as rotas desse controller
public class Controller {

    @GetMapping
    public String raiz(){
        return "rota raiz";
    }

    @GetMapping("/endpoint")
    public String olaMundo(){
        return "Ola mundo";
    }

    @GetMapping("/endpoint/{id}")
    public String exibirum(@PathVariable Integer id){

        return "receber parametro pela url: "+id;
    }

    //criando lista
    private List<String> exibir=new ArrayList<>(
      List.of("primeiro","segundo","terceiro")
    );

    @GetMapping("/listar")
    public List<String> listar(){
     return exibir;
    }

    @GetMapping("/listar/{parametro}")
    public String buscar(@PathVariable int parametro){
        if (parametro>=0&&parametro<exibir.size()){
            return exibir.get(parametro);
        }
     return "não encontrado";
    }

    @DeleteMapping("/listar/{parametro}")
    public String deletar(@PathVariable int parametro){
        if (parametro>=0&&parametro<exibir.size()){
            exibir.remove(parametro);
            return "registro excluido";
        }
        return "não encontrado";
    }
}
