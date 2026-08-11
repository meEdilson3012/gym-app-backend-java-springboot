package com.deved.gym.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Entradas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private LocalDate data;
    private LocalTime hora;
    @OneToOne
    private  Cliente cliente;

    public Entradas(){
        super();
    }

    public  Entradas (Cliente cliente){
        this.data= LocalDate.now();
        this.hora= LocalTime.now();
        this.cliente= cliente;
    }
}
