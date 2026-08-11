package com.deved.gym.Model;


import com.deved.gym.DTOs.ClienteRequest;
import com.deved.gym.Repository.ClienteRepository;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true)
    private  String codigo;

    private  String nome;

    @Column(unique = true)
    private  String numero;

    private  String bairro;

    @Column(unique = true)
    private  String bi;

    private  boolean estado=true;

    private LocalDate data;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private  Passe passe;

    public Cliente(){
        super();
    }

    public  Cliente(ClienteRequest dados){
        this.nome= dados.getNome();
        this.codigo= dados.getBi().concat(LocalDate.now().toString());
        this.numero= dados.getNumero();
        this.bi= dados.getBi();
        this.bairro= dados.getBairro();
        this.data= LocalDate.now();

    }




}
