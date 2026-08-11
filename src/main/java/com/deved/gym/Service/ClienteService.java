package com.deved.gym.Service;


import com.deved.gym.DTOs.ClienteCodigo;
import com.deved.gym.DTOs.ClienteRequest;
import com.deved.gym.DTOs.ExeptionHandlerError;
import com.deved.gym.Model.Cliente;
import com.deved.gym.Model.Passe;
import com.deved.gym.Repository.ClienteRepository;
import com.deved.gym.Repository.PasseRepository;
import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasseRepository passeRepository;


    public ClienteCodigo cadastrar(ClienteRequest dados){
        Cliente cliente= new Cliente(dados);

        Cliente clienteSalvo= clienteRepository.save(cliente);

        Passe passe = new Passe(clienteSalvo);
        passeRepository.save(passe);

        return  new ClienteCodigo(clienteSalvo);


    }

    public void  editar(ClienteRequest dados){

    }

    public Cliente  pesquisarPorID(Long idCliente){

            return  clienteRepository.findById(idCliente)
                    .orElseThrow(()-> new ExeptionHandlerError("Cliente Não Encontrado&404"));
    }

    public void  desativar(Long idCliente){
        Cliente cliente= pesquisarPorID(idCliente);
        cliente.setEstado(false);
        clienteRepository.save(cliente);
    }


    public  Cliente pesquisaPoNome(String nome){
        return  clienteRepository.findByNome(nome)
                .orElseThrow(()-> new ExeptionHandlerError("Cliente Não Encontrado&404"));
    }

    public  Cliente pesquisaPoCodigo(String codigo){
        return  clienteRepository.findByCodigo(codigo)
                .orElseThrow(()-> new ExeptionHandlerError("Cliente Não Encontrado&404"));
    }


    public  Cliente pesquisaPoNumero(String numero){
        return  clienteRepository.findByNumero(numero)
                .orElseThrow(()-> new ExeptionHandlerError("Cliente Não Encontrado&404"));
    }

    public  Integer totalClientes(){
        return  clienteRepository.totalClientes();
    }


}
