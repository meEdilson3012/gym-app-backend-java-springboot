package com.deved.gym.DTOs;


public class ClienteRequest {

    private  Long id;
    private  String nome;
    private  String numero;
    private  String bairro;
    private  String bi;


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        String num= this.numero;
        boolean comeco= num.startsWith("95") || num.startsWith("96");
        boolean completou= num.length()==9;
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getBi() {
        String bi= this.bi;
        boolean primeiroNumeros = bi.startsWith("000");
        boolean numeroCompleto= bi.length()==9;
        // Boolean temLetra= bi.
        if (!primeiroNumeros || !numeroCompleto){
            throw  new RuntimeException("Nao deu");
        }
        return bi;
    }
}
