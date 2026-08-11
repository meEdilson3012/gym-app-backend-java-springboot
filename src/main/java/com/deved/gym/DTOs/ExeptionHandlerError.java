package com.deved.gym.DTOs;

import org.springframework.http.HttpStatus;


public class ExeptionHandlerError extends RuntimeException{

    public ExeptionHandlerError(String mensagem){
        super(mensagem);
    }
}
