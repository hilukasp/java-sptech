package com.example.SpringValidationBean.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class CarroRequestDto {
    @NotNull
    @NotBlank
    @Size(min =2,max = 40) //varchar
    private String modelo;


    @PastOrPresent //passado ou presente
    private LocalDate dataFabricacao;

    @PositiveOrZero //mais
    //@Min(10)
    @DecimalMax(value = "100.0",message = "exemplo de mensagem de erro")
    private Double preco;
    private Boolean automatico;

    //@CPF
    //@Email(regexp = "")

    public CarroRequestDto(){

    }
    public CarroRequestDto(String modelo, LocalDate dataFabricacao, Double preco, Boolean automatico) {
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
        this.preco = preco;
        this.automatico = automatico;
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
