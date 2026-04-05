package com.example.SpringValidationBean.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class CarroResponseDto {
    private Integer id;
    private String modelo;
    private LocalDate dataFabricacao;
    private Double preco;
    private Boolean automatico;

    public CarroResponseDto(){

    }
    public CarroResponseDto(Integer id, String modelo, LocalDate dataFabricacao, Double preco, Boolean automatico) {
        this.id = id;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
        this.preco = preco;
        this.automatico = automatico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getAutomatico() {
        return automatico;
    }

    public void setAutomatico(Boolean automatico) {
        this.automatico = automatico;
    }
}
