package com.deved.gym.DTOs;

import com.deved.gym.Model.Cliente;

public record ClienteCodigo(String codigo) {

    public ClienteCodigo(Cliente dados){
        this(dados.getCodigo());
    }
}
