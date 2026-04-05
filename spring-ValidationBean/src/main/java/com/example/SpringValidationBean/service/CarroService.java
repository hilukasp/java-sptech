package com.example.SpringValidationBean.service;

import com.example.SpringValidationBean.model.Carro;
import com.example.SpringValidationBean.repository.CarroRepository;
import com.example.SpringValidationBean.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired //injeção de dependência
    private CarroRepository repository;

    public List<Carro> listar(){
        return repository.findAll();
    }

    public Carro cadastrar(Carro entity){
        Carro carro = repository.save(entity);
        return carro;
    }

    public Optional<Carro> pesquisar(Integer id){
        Optional<Carro> byId = repository.findById(id);

        if (byId.isEmpty()){
            throw new EntidadeNaoEncontradaException("Carro nao encontrado");
        }
        return byId;
    }
}
