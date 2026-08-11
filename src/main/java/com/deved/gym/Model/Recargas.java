package com.deved.gym.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Recargas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  double montante;
    private LocalDate data;
    private LocalTime hora;
    @OneToOne
    private  Cliente cliente;


    public Recargas(){
        super();
    }

    public  Recargas(Cliente cliente,double montante){
        this.data= LocalDate.now();
        this.hora= LocalTime.now();
        this.cliente= cliente;
        this.montante= montante;
    }
}
