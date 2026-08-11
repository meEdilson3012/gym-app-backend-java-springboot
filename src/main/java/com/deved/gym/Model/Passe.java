package com.deved.gym.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Passe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  Double montante;
    private  Boolean estado;


    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "clienti_id",nullable = false)
    private  Cliente cliente;

    public Passe(){
        super();
    }

    public Passe(Cliente cliente){
        this.cliente= cliente;
        this.montante=0.0;
        this.estado=true;
    }

}
