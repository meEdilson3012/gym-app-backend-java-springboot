package com.deved.gym.Controller;


import com.deved.gym.DTOs.Recarregamento;
import com.deved.gym.Model.Entradas;
import com.deved.gym.Model.Recargas;
import com.deved.gym.Service.PasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/r&c")
public class RecarregamentoController {

    @Autowired
    private PasseService passeService;

    @PostMapping("/recarregar")
    public ResponseEntity<?> recarregamento(@RequestBody Recarregamento dados){
        System.out.printf(dados.getCodigoCliente().toString());
        passeService.recarregar(dados);
        return  ResponseEntity.ok().build();

    }

    @GetMapping("/acesso/{codigo}")
    public ResponseEntity<?> acesso(@PathVariable String codigo){

        passeService.verificarPasse(codigo);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/historico/{codigo}")
    public ResponseEntity<?> historico(@PathVariable String codigo){

       List<Recargas>  recargas= passeService.historico(codigo);
        return  ResponseEntity.ok(recargas);
    }

    @GetMapping("/entradas/{codigo}")
    public ResponseEntity<?> entradas(@PathVariable String codigo){

        List<Entradas>  entradas= passeService.entradas(codigo);
        return  ResponseEntity.ok(entradas);
    }

    @GetMapping("/total-entradas")
    public  ResponseEntity<?> totalEntradas(){
        return  ResponseEntity.ok(passeService.totalEntradas());
    }

    @GetMapping("/total-recargas")
    public  ResponseEntity<?> totalRecargas(){
        return  ResponseEntity.ok(passeService.totalRecargas());
    }

    @GetMapping("/total-recargas-data")
    public  ResponseEntity<?> totalRecargasData(){
        return  ResponseEntity.ok(passeService.totalRecargasData());
    }



}
