package com.example.introducao_spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    private  List<Filme> filmes=new ArrayList<>(
            List.of(
                    new Filme("Shrek 2",2004),
                    new Filme("Titanic",1999),
                    new Filme("Avatar",2008),
                    new Filme("Jurassic Park",2010)
            )
    );

    @PostMapping //ResponseEntity, Classe de resposta da api rest
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme novoFilme){//body do json
        filmes.add(novoFilme);
        return ResponseEntity.status(201).body(novoFilme);
    }

//    @PostMapping
//    public Filme cadastrar(@RequestBody Filme novoFilme){
//        filmes.add(novoFilme);
//        return novoFilme;
//    }

    @GetMapping
    public ResponseEntity<List<Filme>> consultar(){
        return ResponseEntity.status(200).body(filmes);
    }

    @PutMapping("/{parametro}")
    public ResponseEntity<Filme> atualizar(@PathVariable int parametro, @RequestBody Filme novoFilme){
        if (parametro>=0&&parametro<filmes.size()){
            filmes.set(parametro,novoFilme);
            return ResponseEntity.status(200).body(novoFilme);
        }
        return null;
    }


    @DeleteMapping("/{parametro}")
    public ResponseEntity<String> deletar(@PathVariable int parametro){
        if (parametro>=0&&parametro<filmes.size()){
            filmes.remove(parametro);
            return ResponseEntity.status(200).body("filme deletado");
        }
        return null;
    }

    @GetMapping("/{parametro}")
    public ResponseEntity<Filme> buscar(@PathVariable int parametro){
        if (parametro>=0&&parametro<filmes.size()){
            Filme filme=filmes.get(parametro);
            return ResponseEntity.status(200).body(filme);
        }
        return null;
    }

}
