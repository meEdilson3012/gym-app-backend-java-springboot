package com.deved.gym.Controller;


import com.deved.gym.DTOs.ClienteCodigo;
import com.deved.gym.DTOs.ClienteRequest;
import com.deved.gym.Model.Cliente;
import com.deved.gym.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;


    @PostMapping("/add")
    public ResponseEntity<?> cadastrar(@RequestBody ClienteRequest dados){
        ClienteCodigo clienteCodigo= clienteService.cadastrar(dados);

        return  ResponseEntity.status(HttpStatus.CREATED).body(clienteCodigo);

    }

    @GetMapping("/por-id/{idCliente}")
    public  ResponseEntity<?> consultar(@PathVariable Long idCliente){
        Cliente cliente = clienteService.pesquisarPorID(idCliente);
        return  ResponseEntity.ok(cliente);
    }

    @GetMapping("/por-nome/{nome}")
    public  ResponseEntity<?> consultarNome(@PathVariable String nome){
        Cliente cliente = clienteService.pesquisaPoNome(nome);
        return  ResponseEntity.ok(cliente);
    }

    @GetMapping("/por-numero/{numero}")
    public  ResponseEntity<?> consultarNumero(@PathVariable String numero){
        Cliente cliente = clienteService.pesquisaPoNumero(numero);
        return  ResponseEntity.ok(cliente);
    }

    @GetMapping("/por-codigo/{codigo}")
    public  ResponseEntity<?> consultarCodigo(@PathVariable String codigo){
        Cliente cliente = clienteService.pesquisaPoCodigo(codigo);
        return  ResponseEntity.ok(cliente);
    }

    @GetMapping("/total")
    public  ResponseEntity<?> totalClientes(){
        return  ResponseEntity.ok(clienteService.totalClientes());
    }

    @DeleteMapping("/desativar/{idCliente}")
    public  ResponseEntity<?>  desativar(@Validated @PathVariable Long idCliente){
        clienteService.desativar(idCliente);
        return ResponseEntity.ok().build();
    }





}
