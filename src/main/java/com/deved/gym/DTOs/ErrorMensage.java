package com.deved.gym.DTOs;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMensage {

    private  String descricao;
    private HttpStatus status;

    public ErrorMensage(String descricao, HttpStatus status) {
        this.descricao = descricao;
        this.status = status;
    }
}
