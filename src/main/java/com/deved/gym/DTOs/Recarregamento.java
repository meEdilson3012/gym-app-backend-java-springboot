package com.deved.gym.DTOs;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Recarregamento {

    private  String codigoCliente;
    private  double montante;


}
