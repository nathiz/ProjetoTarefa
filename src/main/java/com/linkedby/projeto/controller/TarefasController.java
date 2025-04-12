package com.linkedby.projeto.controller;

import org.springframework.web.bind.annotation.RestController;

import com.linkedby.projeto.model.Tarefas;
import com.linkedby.projeto.service.TarefasService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Bean que faz o controle da chamada
@RestController
//Bean onde o endpoint é igual
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefasService;
    
    //Buscar tarefas em geral
    @GetMapping
    public ResponseEntity<List<Tarefas>> listarTarefas() {
        return ResponseEntity.ok(tarefasService.listarTodas());
    }

    //Buscar tarefas pelo Id
    @GetMapping("/{id}")
    public ResponseEntity<Tarefas> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(tarefasService.buscarPorId(id));
    }
    
    //Adicionar Tarefas
    @PostMapping
    public ResponseEntity<Tarefas> criarTarefa(@RequestBody Tarefas tarefa) {
        return ResponseEntity.ok(tarefasService.criar(tarefa));
    }
    
    //Alterar Tarefas pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Tarefas> atualizarTarefa(@PathVariable UUID id, @RequestBody Tarefas tarefa) {
        return ResponseEntity.ok(tarefasService.atualizar(id, tarefa));
    }

    //Deletar Tarefas
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable UUID id) {
        tarefasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}