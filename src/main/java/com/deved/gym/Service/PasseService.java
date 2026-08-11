package com.deved.gym.Service;


import com.deved.gym.DTOs.ClienteRequest;
import com.deved.gym.DTOs.ExeptionHandlerError;
import com.deved.gym.DTOs.Recarregamento;
import com.deved.gym.Model.Cliente;
import com.deved.gym.Model.Entradas;
import com.deved.gym.Model.Passe;
import com.deved.gym.Model.Recargas;
import com.deved.gym.Repository.EntradasRepository;
import com.deved.gym.Repository.PasseRepository;
import com.deved.gym.Repository.RecargasRepository;
import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PasseService {


    @Autowired
    private PasseRepository passeRepository;

    @Autowired
    private EntradasRepository entradasRepository;

    @Autowired
    private RecargasRepository recargasRepository;


    public  void recarregar(Recarregamento dados){

        boolean montante= dados.getMontante()>500.0;

        if (!montante){
            throw  new ExeptionHandlerError("Só pode recarregar a partir de 500 XOF&400");
        }
        Optional<Passe> passe= passeRepository.clientePasse(dados.getCodigoCliente());
        if (passe.isEmpty()){
            throw  new ExeptionHandlerError("Não existi cliente com relacionado a este Qrcode&400");
        }

        passe.get().setMontante(dados.getMontante());

        passeRepository.save(passe.get());

        recargasRepository.save(
                new Recargas(passe.get().getCliente(), passe.get().getMontante())
        );


    }

    public void  verificarPasse(String codigo){
        Optional<Passe> passeEncontrado= passeRepository.clientePasse(codigo);
        if (passeEncontrado.isEmpty()){
            throw  new ExeptionHandlerError("Não existi cliente com relacionado a este Qrcode&404");
        }

        boolean montante= passeEncontrado.get().getMontante() >= 500;
        if (!montante){
            throw  new ExeptionHandlerError("Sem saldo para puder entrar&400");
        }
        if (entradasRepository.jaEntrou(codigo, LocalDate.now()).isPresent()){
            throw  new ExeptionHandlerError("Já tem um cliente registrada hoje com este Qrcode&400");
        }

        passeEncontrado.get().setMontante(passeEncontrado.get().getMontante()-500);
        passeRepository.save(passeEncontrado.get());
        Entradas entradas= new Entradas(
                passeEncontrado.get().getCliente()
        );
        entradasRepository.save(entradas);
    }


    public List<Recargas> historico (String codigo){

        return  recargasRepository.clienterecarga(codigo);

    }

    public List<Entradas> entradas (String codigo){

        return  entradasRepository.clienteEntradas(codigo);

    }

    public Integer totalEntradas(){
        return  entradasRepository.totalEntradas(LocalDate.now());
    }

    public Integer totalRecargasData(){
        return  recargasRepository.totalRecargas(LocalDate.now());
    }

    public Integer totalRecargas(){
        return  recargasRepository.totalRecargas();
    }

}
