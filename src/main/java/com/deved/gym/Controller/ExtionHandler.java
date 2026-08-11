package com.deved.gym.Controller;

import com.deved.gym.DTOs.ErrorMensage;
import com.deved.gym.DTOs.ExeptionHandlerError;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExtionHandler  {


    @ExceptionHandler(ExeptionHandlerError.class)
    public ResponseEntity<?> handleExeptions(ExeptionHandlerError ex ){
        int status=Integer.parseInt(ex.getMessage().split("&")[1]) ;
        String message= ex.getMessage().split("&")[0];
        return  ResponseEntity
                .status(status)
                .body(
                new ErrorMensage(
                        message,
                        HttpStatus.resolve(status)
                )
                );

    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleExeptions(RuntimeException ex ){
        return  ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        new ErrorMensage(
                                ex.getMessage(),
                                HttpStatus.INTERNAL_SERVER_ERROR
                        )
                );

    }


}
