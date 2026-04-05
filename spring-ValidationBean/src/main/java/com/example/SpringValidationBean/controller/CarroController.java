package com.example.SpringValidationBean.controller;

import com.example.SpringValidationBean.model.Carro;
import com.example.SpringValidationBean.dto.CarroMapper;
import com.example.SpringValidationBean.dto.CarroRequestDto;
import com.example.SpringValidationBean.dto.CarroResponseDto;
import com.example.SpringValidationBean.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService service;

    @GetMapping
    private ResponseEntity<List<CarroResponseDto>> consultarCarro(){
        List<Carro> carros= service.listar();
        if (carros.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        //converter
        List<CarroResponseDto> responseDto = CarroMapper.toResponseDto(carros);
        return ResponseEntity.status(200).body(responseDto);

    }

    @PostMapping
    private ResponseEntity<CarroResponseDto> cadastrarCarro( @Valid @RequestBody CarroRequestDto dto){
        Carro requestDto=CarroMapper.toEntity(dto);

        Carro carro=service.cadastrar(requestDto);

        CarroResponseDto responseDto=CarroMapper.toResponseDto(carro);
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDto> pesquisarCarro(@PathVariable Integer id){
        Optional<Carro> listacarro =service.pesquisar(id);
        Carro carroEncontrado=listacarro.get();
        CarroResponseDto responseDto=CarroMapper.toResponseDto(carroEncontrado);
        return ResponseEntity.status(200).body(responseDto);
    }
}
