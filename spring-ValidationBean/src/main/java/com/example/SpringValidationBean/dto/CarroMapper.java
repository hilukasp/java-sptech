package com.example.SpringValidationBean.dto;

import com.example.SpringValidationBean.model.Carro;

import java.util.List;


public class CarroMapper {
    //função para reutilizar o código, transferir o dtoRequest para dtoResponse
    public static CarroResponseDto toResponseDto(Carro entity){
        if (entity==null){
            return null;
        }

        CarroResponseDto dto=new CarroResponseDto();
        dto.setId(entity.getId());
        dto.setModelo(entity.getModelo());
        dto.setDataFabricacao(entity.getDataFabricacao());
        dto.setAutomatico(entity.getAutomatico());
        dto.setPreco(entity.getPreco());

        return dto;
    }

    public static List<CarroResponseDto> toResponseDto(List<Carro> entities){
        return entities.stream().map(CarroMapper::toResponseDto).toList();

        /*
        List<CarroResponseDto> lista = new ArrayList<>();

        for (Carro entity : entities) {
            lista.add(CarroMapper.toResponseDto(entity));
        }

        return lista;
         */

    }

    public static Carro toEntity(CarroRequestDto dto){ //oq esse método faz?
        if (dto==null){
            return null;
        }

        Carro entidade = new Carro(dto.getModelo(),dto.getDataFabricacao(),dto.getPreco(),dto.getAutomatico());

        return entidade;
    }

}
